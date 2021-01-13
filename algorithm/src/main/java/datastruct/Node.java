package datastruct;

public class Node {
    private Node next;
    private Integer value;

    public Node(Node node, Integer value) {
        this.next = node;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }
}
