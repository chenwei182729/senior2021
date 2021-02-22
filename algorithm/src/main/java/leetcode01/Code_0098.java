package leetcode01;

import sun.util.resources.is.CalendarData_is;

import java.util.ArrayList;
import java.util.List;

public class Code_0098 {
    public boolean isValidBST2(TreeNode root) {
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean _isValidBST(TreeNode node, long lower, long upper) {
        if(node==null){
            return true;
        }
        if(node.val<=lower||node.val>=upper){
            return false;
        }

        return _isValidBST(node.left,lower,node.val) && _isValidBST(node.right,node.val,upper);
    }
    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


    private List<Integer> result;

    public boolean isValidBST(TreeNode root) {
        result = new ArrayList<>();
        _traval(root);
        return isOrdered(result);
    }

    private boolean isOrdered(List<Integer> result) {
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i - 1) >= result.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void _traval(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            _traval(root.left);
        }

        result.add(root.val);

        if (root.right != null) {
            _traval(root.right);
        }
    }

    public static void main(String[] args) {
        Code_0098 code_0283 = new Code_0098();

    }
}
