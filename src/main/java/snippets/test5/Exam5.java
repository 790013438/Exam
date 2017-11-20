package snippets.test5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam5 {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(80)) {
            while (true) {
                Socket client = server.accept();
                System.out.println(client.getInetAddress() + "连接到服务器。");
                service.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {

        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (InputStream in = client.getInputStream();
                 OutputStream out = client.getOutputStream()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String requestLine = br.readLine();
                String resourceName = requestLine.split("\\s")[1].substring(1);

                String suffix = getSuffix(resourceName);
                String mimeType = "text/html";
                if (suffix != null) {
                    switch (suffix) {
                        case "jpg" : mimeType = "image/jpeg"; break;
                        case "png" : mineType = "image/png"; break;
                        case "pdf" : mineType = "application/pdf"; break;
                    }
                }

                InputStream resourceIn = getClass().getClassLoader().getResourceAsStream(resourceName);
                byte[] buffer = new byte[resourceIn.available()];
                resourceIn.read(buffer);
                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write(("Content-Length:" + buffer.length + "\r\n").getBytes());
                out.write(("Content-Type" + mimeType + "\r\n").getBytes());
                out.write("\r\n".getBytes());
                out.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String getSuffix(String filename) {
            int pos = filename.lastIndexOf(".");
        }
    }
}
