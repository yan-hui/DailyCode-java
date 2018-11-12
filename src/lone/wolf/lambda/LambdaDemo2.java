package lone.wolf.lambda;

import org.junit.Test;
import sun.java2d.SurfaceDataProxy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo2 {
    public static void main(String[] args) {
        /**
         * 过滤
         */
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        Person p5 = new Person();
        p1.setId("123");
        p1.setName("小何");
        p1.setDescription("ahahahahah");
        p1.setAge(23);
        p5.setId("123");
        p5.setName("小何");
        p5.setDescription("ahahahahah");
        p5.setAge(23);

        p2.setId("456");
        p2.setName("小王");
        p2.setDescription("叩叩叩看");
        p2.setAge(22);

        p3.setId("789");
        p3.setName("小李");
        p3.setDescription("哈哈哈哈哈哈哈");
        p3.setAge(25);

        p4.setId("098");
        p4.setName("小杨");
        p4.setDescription("嘻嘻嘻");
        p4.setAge(21);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        Stream<Person> distinct = people.stream().distinct();
        Object[] obj = distinct.toArray();
        System.out.println(Arrays.toString(obj));
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        Stream<Person> personOver18 = people.stream().filter(person -> person.getAge() >= 23);
        Object[] objects = personOver18.toArray();
        System.out.println(Arrays.toString(objects));

        System.out.println("--------------------");
        /**
         * Map(对元素进行操作)
         */
        Stream<Adult> adultStream = people.stream().filter(person -> person.getAge() >= 22).map(person -> new Adult(person));
        Object[] objects2 = adultStream.toArray();
        System.out.println(Arrays.toString(objects2));


        System.out.println("++++++++++++++++++++++++++");


        /**
         * 统计
         */
        long personNum = people.stream().filter(person -> person.getAge() > 22).count();
        System.out.println("人数：" + personNum);
        System.out.println("------------------------------------------------");
        /**
         * Collect(收集流的结果)
         */
        long t1 = System.nanoTime();
        List<Person> collect = people.stream().filter(person -> person.getAge() > 22).collect(Collectors.toList());
        System.out.println(collect);
        long t2 = System.nanoTime();
        List<Person> collect2 = people.stream().parallel().filter(person -> person.getAge() > 22).collect(Collectors.toList());
        long t3 = System.nanoTime();
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t2 - t1) * 1e-9, (t3 - t2) * 1e-9);


    }

    @Test
    public void testStream() {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(1);
        nums.add(2);
        nums.add(null);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(null);
        nums.add(7);
//        Stream<Integer> stream = nums.stream();
//        Stream<Integer> integerStream = stream.filter(team -> team != null);
//        Stream<Integer> distinct = integerStream.distinct();
//        IntStream intStream = distinct.mapToInt(num -> num * 2);
//        IntStream skip = intStream.skip(2);
//        IntStream limit = skip.limit(4);
//        System.out.println(limit);
        System.out.println("求和：" + nums
                .stream()//转成strem
                .filter(team -> team != null)//过滤
                .distinct()//去重
                .mapToInt(num -> num * 2)//map操作
                .skip(2)//跳过前两个
                .limit(4)//限制取前四个
                .peek(System.out::println)//流处理对象函数
                .sum()
        );
    }

}
