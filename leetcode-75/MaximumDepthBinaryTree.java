/*
 * Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along 
the longest path from the root node down to the farthest 
leaf node.

          1
       2    3
      4 5  6 7
     8        9
               10


      1
    2   3
   4 5
*/
import com.example.lib.TreeNode;

class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(10);
        TreeNode t9 = new TreeNode(9, null, t10);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7, null, t9);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4, t8, null);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        int max = maxDepth(t1);
        p(max + "");
    }
    public static void p(String s) {
        System.out.println(s);
    }
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}
