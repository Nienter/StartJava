package com.example.lib2.offer;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            if (x <= stack2.peek()) {
                stack2.push(x);
            }
        }
    }

    public void pop() {
        if (stack2.peek().equals(stack1.peek())) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.pop();
        System.out.println(minStack.min());
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.push(1);
//        linkedList.push(2);
//        linkedList.push(3);
//        System.out.println(linkedList.getFirst());
    }
}
