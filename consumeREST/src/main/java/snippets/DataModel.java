package snippets;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DataModel {

    private int total;
    private List<Result> result;

    @JsonProperty("error_code")
    private String errorCode;

    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

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
