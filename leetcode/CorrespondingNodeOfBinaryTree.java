/*

Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

original:
       1
    2     3
  4  5   6 7
target: target.val = 6

cloned:
       1
    2     3
  4  5   6 7
*/
import java.util.LinkedList;
import java.util.Queue;
import com.example.lib.TreeNode;

class CorrespondingNodeOfBinaryTree {
  public static void main(String[] args) {
    TreeNode o4 = new TreeNode(4);
    TreeNode o5 = new TreeNode(5);
    TreeNode o6 = new TreeNode(6);
    TreeNode o7 = new TreeNode(7);
    TreeNode o2 = new TreeNode(2, o4, o5);
    TreeNode o3 = new TreeNode(3, o6, o7);
    TreeNode o1 = new TreeNode(1, o2, o3);

    TreeNode c4 = new TreeNode(4);
    TreeNode c5 = new TreeNode(5);
    TreeNode c6 = new TreeNode(6);
    TreeNode c7 = new TreeNode(7);
    TreeNode c2 = new TreeNode(2, c4, c5);
    TreeNode c3 = new TreeNode(3, c6, c7);
    TreeNode c1 = new TreeNode(1, c2, c3);
 
    TreeNode ans = getTargetCopy(o1, c1, o5);
    if (ans != null) System.out.println(ans.val);

  }
  public static final TreeNode getTargetCopy(
      final TreeNode original, 
      final TreeNode cloned, 
      final TreeNode target) {
    return bfs(cloned, target);
  }
  public static TreeNode bfs(TreeNode node, TreeNode target) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    return bfsHelper(queue, target);
  }
  public static TreeNode bfsHelper(Queue<TreeNode> queue, TreeNode target) {
    while(queue.peek() != null) {
      TreeNode node = queue.poll();
      if (node.val == target.val) return node;
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
    return null;
  }
}

