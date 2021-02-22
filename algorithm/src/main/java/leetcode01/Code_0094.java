package leetcode01;

import java.util.ArrayList;
import java.util.List;

public class Code_0094 {
    private List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        _inOrder(root);
        return result;
    }

    private void _inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            _inOrder(node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            _inOrder(node.right);
        }
    }


    public static void main(String[] args) {

    }
}
