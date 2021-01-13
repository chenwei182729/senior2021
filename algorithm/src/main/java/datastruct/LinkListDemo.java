package datastruct;

public class LinkListDemo {
    public static void main(String[] args) {
        Node node = headInsert(100);
        print(node);
        node = reverse(node);
        System.out.println("\nreverse");
        print(node);
//        System.out.println("tail insert");
//        final Node node1 = tailInsert(10);
//        print(node1);
    }

    public static void print(Node head) {
        for (Node n = head; n != null; n = n.getNext()) {
            System.out.print(n.getValue() + " ");
        }
    }

    private static Node reverse(Node node) {
        Node head = new Node(null, 0);
        Node tmp;
        for (Node n = node; n != null; n = tmp) {
            tmp = n.getNext();
            n.setNext(head.getNext());
            head.setNext(n);
        }
        return head.getNext();
    }

    private static Node tailInsert(int n) {
        Node head = new Node(null, 0);
        Node tail = head;

        for (int i = 0; i < n; i++) {
            Node tmp = new Node(null, i);
            tail.setNext(tmp);
            tail = tail.getNext();
        }

        //help gc
        Node tmp = head;
        tmp = null;
        head = head.getNext();
        return head;
    }

    public static Node headInsert(int n) {
        Node head = null;
        for (int i = 0; i < n; i++) {
            head = new Node(head, i);
        }
        return head;
    }

}



