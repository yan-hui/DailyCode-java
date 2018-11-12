package lone.wolf.link;

/**
 * @ClassName DoubleLinkeList
 * @Description 实现双向链表
 * @Author hechunhui
 * @Date 2018/5/18 15:07
 */
public class DoubleLinkeList<E> {
    //链表节点数
    private int size;

    private Node<E> first;//头节点
    private Node<E> last;//尾节点

    /**
     * 得到节点数
     * @return
     */
    public int size(){
        return size;
    }
    /**
     * 尾插法
     * @param e
     */
    public void addLast(E e){
        Node<E> newNode = new Node<E>(null,e,null);
        if (null==first){
            first = newNode;
        }else{
            last.next = newNode;
            newNode.prev =last;

        }
        last = newNode;
        size++;
    }

    /**
     * 头插法
     * @param e
     */
    public void addFirst(E e){
        Node<E> newNode = new Node<E>(null,e,null);
        if (null==first){
            last = newNode;
        }else{
            first.prev = newNode;
            //第一个节点后移一位
            newNode.next = first;
        }
        //新节点作为第一个节点
        first = newNode;
        size++;
    }

    /**
     * 删除头节点
     */
    public void removeFirst(){
        if (null==first){
            System.out.println("该节点不存在！");
        }
        Node<E> temp = first;
        if (first.next==null){//只有一个节点
            last=null;

        }else{
            first.next.prev = null;//将原先头节点的前驱设为null
        }
        first = temp.next;
        size--;
    }


    /**
     * 删除尾节点
     */
    public void removeLast(){
        if (null==first){
            System.out.println("节点未找到！！！");
        }
        Node<E> temp = last;
        if (null==first.next){
            first = null;
            last = null;
        }else{
            last.prev.next =null;
            last.prev=null;
            last.element=null;
        }
        last = temp.prev;
        size--;
    }

    public E getByIndex(int index){
        if (index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> currNode = first;
        int num = 0;
        while (num<index-1){
            currNode = currNode.next;
            num++;
        }
        return currNode.element;
    }







    private static class Node<E>{
        Node<E> prev;//前驱
        E element;//数据
        Node<E> next;//后继

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }




}
