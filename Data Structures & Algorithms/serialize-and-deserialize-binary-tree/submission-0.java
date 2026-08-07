/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder result = new StringBuilder();
        dfsSerialize(root, result);

        return result.substring(0 , result.length() - 1);
    }

    private void dfsSerialize(TreeNode node, StringBuilder result) {

        if(node == null) {
            result.append("n,");
            return;
        }

        result.append(node.val + ",");

        dfsSerialize(node.left, result);
        dfsSerialize(node.right, result);
    }

    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        index = 0;
        return dfsDeserialize(nodes);
    }

    private TreeNode dfsDeserialize(String[] nodes) {

        if (index >= nodes.length) {
            return null;
        }

        if (nodes[index].equals("n")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index++]));
        
        node.left = dfsDeserialize(nodes);
        node.right = dfsDeserialize(nodes);

        return node;
    }
}
