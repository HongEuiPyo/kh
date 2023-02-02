package hello1;

import groovy.console.ui.Console;

public class Hello1 {

    private String id;
    private String pw;
    private String email;

    @Override
    public String toString() {
        return "Hello1{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
