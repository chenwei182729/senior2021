package leetcode01;

public class Code_0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1. 反转
        l1 = reverseListNode(l1);
        l2 = reverseListNode(l2);
        //2. 相加
        ListNode res = addListNode(l1, l2);
        //3. 反转
        reverseListNode(res);
        return res;
    }

    private ListNode addListNode(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode head = new ListNode();
        while (l1 != null && l2 != null) {
            int val = tmp + l1.val + l2.val;
            tmp = val / 10;
            val = val % 10;
            ListNode tmpNode = new ListNode(val, head.next);
            head.next = tmpNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = tmp + l1.val;
            tmp = val / 10;
            val = val % 10;
            ListNode tmpNode = new ListNode(val, head.next);
            head.next = tmpNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = tmp + l2.val;
            tmp = val / 10;
            val = val % 10;
            ListNode tmpNode = new ListNode(val, head.next);
            head.next = tmpNode;
            l2 = l2.next;
        }

        ListNode result = head.next;
        head = null;//help gc
        return result;
    }

    private ListNode reverseListNode(ListNode l1) {
        ListNode head = new ListNode();
        for (; l1 != null; l1 = l1.next) {
            l1.next = head.next;
            head.next = l1;
        }
        ListNode result = head.next;
        head = null;//help gc
        return result;
    }
}
