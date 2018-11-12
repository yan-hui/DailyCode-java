package lone.wolf.link;


import java.util.LinkedList;

/**
 * @ClassName LinkedDemo2
 * @Description 模拟单链表
 * @Author hechunhui
 * @Date 2018/5/18 9:32
 */
public class LinkedDemo2<E> {
    private int size;
    private Node<E> first;
    /**
     * 新增节点,尾插法
     *
     * @param e
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        Node<E> temp = first;
        if (temp == null) {
            first = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;

        }
        size++;
    }
    public void add(E e){
        addLast(e);
    }


    /**
     * 新增节点,头插法
     *
     * @param e
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, null);
        Node<E> temp = first;
        first = newNode;
        newNode.next = temp;
        size++;
    }

    /**
     * 往指定节点后面插入一个节点
     *
     * @param e
     * @param index
     */
    public void addToIndex(E e, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(e, null);
        Node<E> temp = first;
        int count=0;
        if (index == 0) {
            if (size == 0) {
                first = newNode;
            } else {
                newNode.next = temp.next;//新节点的下一个节点为上一个节点的原下一个节点
                temp.next = newNode;//原节点的下一个节点为新插入节点
            }
        } else {
            while (count<index-1){
                newNode.next = temp.next;
                temp.next = newNode;
            }

        }
        size++;

    }




    /**
     * 删除节点
     *
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node<E> temp = first;
        if (index == 0) {
            first = first.next;
        } else {
            while (count < index - 1) {
                temp = temp.next;
                count++;
            }
            temp.next = temp.next.next;//当前结点的下个节点变成下下个节点
        }

        size--;

    }

    public int size() {
        return size;
    }


    public static class Node<E> {
        Node<E> next;
        E element;


        public Node(E element, Node<E> next) {
            this.next = next;
            this.element = element;
        }
    }
}
