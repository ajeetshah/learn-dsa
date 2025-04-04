/*

push()
pop()
peek()
empty()

*/

package com.example.lib;

public class StackUsingArray {

  private int[] arr;
  private int size;
  private int top;

  public StackUsingArray(int size) {
    if (size < 1) {
      System.out.println("Size should be 1 or more");
    } else {
      this.arr = new int[size];
      this.size = size;
      this.top = -1;
    }
  }

  public boolean push(int x) {
    if (this.top == this.size - 1) {
      System.out.println("Stack is full");
      return false;
    }
    this.arr[++this.top] = x;
    return true;
  }

  public int pop() {
    if (this.top == -1) {
      System.out.println("Stack is empty");
      return 0;
    } else {
      return this.arr[this.top--];
    }
  }

  public int peek() {
    if (this.top == -1) {
      System.out.println("Stack is empty");
      return 0;
    } else {
      return this.arr[this.top];
    }

  }

}
