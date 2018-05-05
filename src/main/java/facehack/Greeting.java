package facehack;

public class Greeting {

    private final long id;
    private final String user;
    private final String content;

    public Greeting(long id, String user, String content) {
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getUser(){
      return user;
    }

    public String getContent() {
        return content;
    }
}
