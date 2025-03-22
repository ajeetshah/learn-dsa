/*
https://leetcode.com/problems/search-in-a-binary-search-tree/description

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

E.g.1
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

E.g.2
Input: root = [4,2,7,1,3], val = 5
Output: []

        16
    9      18
  8       17
*/

import com.example.lib.TreeNode;

class SearchBinarySearchTree {
  public static void main(String[] args) {
    TreeNode t8 = new TreeNode(8);
    TreeNode t9 = new TreeNode(9, t8, null);
    TreeNode t17 = new TreeNode(17);
    TreeNode t18 = new TreeNode(18, t17, null);
    TreeNode t16 = new TreeNode(16, t9, t18);
    TreeNode ans = searchBST(t16, 0);
    if(ans != null) System.out.println(ans.val);
  }
  public static TreeNode searchBST(TreeNode root, int val) {
    if(root == null) return null;
    if(root.val == val) return root;
    if(root.val > val) return searchBST(root.left, val);
    if(root.val < val) return searchBST(root.right, val);
    return null;
  }
}
