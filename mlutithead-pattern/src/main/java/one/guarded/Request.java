package one.guarded;

/**
 * @author chenxinwei
 * @date 2021/1/14 18:10
 **/
public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request " + name;
    }
}
