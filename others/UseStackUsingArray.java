import com.example.lib.StackUsingArray;

class UseStackUsingArray {

  public static void main(String[] args) {
    StackUsingArray stack = new StackUsingArray(5);
    
    p(stack.peek());
    p(stack.pop());

    stack.push(100);
    stack.push(200);
    stack.push(300);

    p(stack.peek());
    p(stack.pop());

    stack.push(301);
    stack.push(400);
    stack.push(500);
    stack.push(600);

    p(stack.peek());
    p(stack.pop());
  }

  public static void p(int x) {
    System.out.println(x);
  }

}
