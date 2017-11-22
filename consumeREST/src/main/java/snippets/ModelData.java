package snippets;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ModelData {

    private int total;
    private List<Result> result;

    @JsonProperty("error_code")
    private String errorCode;
    private String reason;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
