package lone.wolf.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class LambdaDemo {
    public static void excuteSay(MyInterface action, String thing) {
        action.saySometing(thing);
    }

    public static void main(String[] args) {
        excuteSay((String s) -> System.out.println(s), "hello world");


        System.out.println("-------------------------------------------------");
        List<String> list = new ArrayList<String>();
        list.add("吼吼");
        list.add("好机会");
        list.add("啊啊");
        list.add("设施");
        list.add("无非");
        list.add("真实");
        list.add("真实");
        Stream<String> distinct = list.stream().distinct();
        /**
         * 去重
         */
        System.out.println(Arrays.toString(distinct.toArray()));

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        list.forEach(str -> System.out.println(str));
        System.out.println("-------------------------------------------------");
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        p1.setId("123");
        p1.setName("小何");
        p1.setDescription("ahahahahah");

        p2.setId("456");
        p2.setName("小王");
        p2.setDescription("叩叩叩看");

        p3.setId("789");
        p3.setName("小李");
        p3.setDescription("哈哈哈哈哈哈哈");

        p4.setId("098");
        p4.setName("小杨");
        p4.setDescription("嘻嘻嘻");

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        /**
         * forEach遍历
         */
        people.forEach(person -> {
                    String name = person.getName();
                    String id = person.getId();
                    String description = person.getDescription();
                    System.out.println(name + "---" + id + "---" + description);
                    System.out.println(person);
                }
        );

        people.sort(comparing(Person::getId));

        System.out.println("===========================================");
        System.out.println(people);





    }
}
