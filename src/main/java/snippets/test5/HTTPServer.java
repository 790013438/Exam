package snippets.test5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator;

    public static void main(String[] args) throws IOException {
        new HTTPServer().doGet();
    }

    public void doGet() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = null;
        boolean f = true;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (f) {
            //等待客户端连接
            socket = serverSocket.accept();
            System.out.println("socket linked!");
            executorService.execute(new ServerThread(socket));
        }
    }

    class ServerThread implements Runnable {
        private Socket socket = null;

        public ServerThread(Socket client) {
            this.socket = client;
        }

        @Override
        public void run() {
            try {
                //获取Socket的输出流，用来向客户端发送数据
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                //获取Socket的输入流，用来接收从客户端发送过来的数据
                InputStream inputStream = socket.getInputStream();
                printStream.print(message);

                printStream.println("<!DOCTYPE html><html>" +
                        "<head><title>aha</title></head>" +
                        "<body><h1>Hello, Java</h1></body>" +

                        "</html>");
                printStream.println();

                Request request = new Request(inputStream);
                request.parse();
                if (request.getUri().equals("/SHUTDOWN")) {
                    socket.close();
                }

                Response response = new Response(printStream);
                response.setRequest(request);
                response.sendStaticResource();

                printStream.print("\r\n");
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    String message = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "\r\n";
}
