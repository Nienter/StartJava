package com.myjava.test;

public class Node<E> {
    E item;
    Node<E> next;
    Node<E> head = null;
    Node<E> tail = null;

    Node(E element) {
        this.item = element;
//        this.next = null;
    }
}
