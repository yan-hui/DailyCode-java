package lone.wolf.link;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.LinkedList;

/**
 * @ClassName LinkeDemo
 * @Description
 * @Author hechunhui
 * @Date 2018/5/17 16:58
 */
public class LinkeDemo<E> {
    private int size;
    private Node first;
    private Node last;

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public int size() {
        return size;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node(l, e, null);
        last = newNode;
        if (null == l) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;

    }

    private static class Node<E> {
        Node<E> next;
        E element;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.next = next;
            this.element = element;
            this.prev = prev;
        }
    }

}
