package snippets;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("famous_name")
    private String famousName;

    @JsonProperty("famous_saying")
    private String famousSaying;

    public String getFamousName() {
        return famousName;
    }

    public void setFamousName(String famousName) {
        this.famousName = famousName;
    }

    public String getFamousSaying() {
        return famousSaying;
    }

    public void setFamousSaying(String famousSaying) {
        this.famousSaying = famousSaying;
    }
}
