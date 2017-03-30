package com.algorithm.list;

/**
 * Created by lijianli on 2017/3/30.
 */
public class Node<T> {
    private T value;
    private Node<T> nextNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
    public Node(T value,Node nextNode){
        this.value=value;
        this.nextNode=nextNode;
    }
}
