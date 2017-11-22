package snippets;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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
