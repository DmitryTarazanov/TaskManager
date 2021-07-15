package jsonController;

import java.util.List;

public class Root {
    private String name;
    private List<JsonData> jsonData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JsonData> getJsonData() {
        return jsonData;
    }

    public void setJsonData(List<JsonData> jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", jsonData=" + jsonData +
                '}';
    }
}
