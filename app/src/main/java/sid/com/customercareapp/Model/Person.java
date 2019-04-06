package sid.com.customercareapp.Model;

public class Person {
    private String name,postition;
    private int viewType;

    public Person() {
    }

    public Person(String name, String postition, int viewType) {
        this.name = name;
        this.postition = postition;
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostition() {
        return postition;
    }

    public void setPostition(String postition) {
        this.postition = postition;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
