/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
     
Example 2:
        1
       2 3
      4   5
     6 7 
    8
Output: 1,3,5,7,8

*/
import com.example.lib.TreeNode;
import java.util.List;
import java.util.ArrayList;

class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6, t8, null);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4, t6, t7);
        TreeNode t3 = new TreeNode(3, null, t5);
        TreeNode t2 = new TreeNode(2, t4, null);
        TreeNode t1 = new TreeNode(1, t2, t3);
        List<Integer> ans = rightSideView(t1);
        for(int a: ans) {
            System.out.println(a);
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }
    public static void helper(TreeNode node, int depth, List<Integer> ans) {
        if(node == null) return;
        if(ans.size() == depth) ans.add(node.val);
        else ans.set(depth, node.val);
        helper(node.left, depth+1, ans);
        helper(node.right, depth+1, ans);
    }
}
