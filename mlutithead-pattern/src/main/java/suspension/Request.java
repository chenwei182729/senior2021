package suspension;

/**
 * @author chenxinwei
 * @date 2020/12/29 18:20
 **/
public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[ Request %s ]", name);
    }
}
