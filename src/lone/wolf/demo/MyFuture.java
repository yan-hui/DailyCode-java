package lone.wolf.demo;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * 生活不易啊
 */
public class MyFuture {
    public static void main(String[] args) {
        int age = 23;
        int salary = 7_000;
        double fundSacle = 0.12;
        double comSacle = 0.05;
        double goal = 500_000;
        int year = 1;
        double now = 0;
        double fund = 0;
        while ((now+fund)<goal){
            System.out.println("第"+year+"年，预想工资 ："+salary);

            fund = fund+(salary*fundSacle+salary*comSacle)*12;
            System.out.println("第"+year+"年公积金账户有-->"+fund);

            now = now+(salary-salary*fundSacle-2000)*12;
            System.out.println("第"+year+"年估计存款--->"+now);

            salary+=2000;
            year++;
            age++;
            System.out.println("----------------------");
        }
        System.out.println(year);
        System.out.println(fund);
        System.out.println(now);
        System.out.println(age);

        new LinkedList<String>();
    }
}
