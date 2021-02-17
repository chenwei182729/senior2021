package leetcode01;

public class Code_0226_2 {
    public TreeNode invertTree(TreeNode root) {
        root = _reverse(root);
        return root;
    }

    private TreeNode _reverse(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = _reverse(node.left);
        TreeNode right = _reverse(node.right);

        node.right = right;
        node.left = left;
        return node;
    }

}
