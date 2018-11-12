package lone.wolf.link;

import org.junit.Test;

/**
 * @ClassName DoubleLinkTest
 * @Description
 * @Author hechunhui
 * @Date 2018/5/18 15:14
 */
public class DoubleLinkTest {
    @Test
    public void addLastTest(){
        DoubleLinkeList<String> list = new DoubleLinkeList<>();
        list.addLast("哈哈");
        System.out.println(list.size());
        list.addLast("嘻嘻嘻");
        list.addLast("拉拉");
        list.addLast("搜索");
        System.out.println(list.size());

//        list.addFirst("吼吼");

        System.out.println(list.size());

//        list.removeFirst();
//        System.out.println(list.size());
//
//        list.removeLast();
//        System.out.println(list.size());

        System.out.println(list.getByIndex(4));
    }
}
