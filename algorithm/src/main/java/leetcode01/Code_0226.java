package leetcode01;

public class Code_0226 {
    public TreeNode invertTree(TreeNode root) {
        _reverse(root);
        return root;
    }

    private TreeNode _reverse(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode right = _reverse(node.left);
        TreeNode left = _reverse(node.right);
        node.left = left;
        node.right = right;
        return node;
    }
}
