package jsonController;

public class JsonData {
    private int id;
    private String project;
    private String client;
    private String task;
    private String state;

    public JsonData(int id, String project, String client, String task, String state) {
        this.id = id;
        this.project = project;
        this.client = client;
        this.task = task;
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setUserName(String userName) {
        this.client = userName;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public String getClient() {
        return client;
    }

    public String getTask() {
        return task;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "id=" + id +
                ", projectName='" + project + '\'' +
                ", userName='" + client + '\'' +
                ", task='" + task + '\'' +
                ", state=" + state +
                '}';
    }
}
