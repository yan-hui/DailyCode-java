package lone.wolf.link;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @ClassName LinkTest
 * @Description
 * @Author hechunhui
 * @Date 2018/5/17 17:50
 */
public class LinkTest {
    @Test
    public void testAdd(){
        LinkeDemo<String> demo = new LinkeDemo<>();
        demo.add("哈哈");
        System.out.println(demo.size());
        System.out.println(demo);
    }
    @Test
    public void testAdd2(){
        LinkedDemo2<String> demo = new LinkedDemo2<>();
        demo.add("第一");
        demo.add("嘻嘻");
        demo.add("啊啊");
        demo.add("对等");
        demo.add("最后");
        new LinkedList<>();
        System.out.println(demo.size());
        demo.addFirst("lalal");
//        demo.addToIndex("啦啦啦啦",0);
//        demo.addToIndex("啦啦啦啦2",0);
        System.out.println(demo.size());
//        demo.remove(1);
//        System.out.println(demo.size());
    }
}
