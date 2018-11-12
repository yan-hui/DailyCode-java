package lone.wolf.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author wm
 * @Title IDUtils
 * @date 2018/8/13 19:59
 * @Version 1.0
  */
public class IDUtils {


    private static String format = "yyyyMMdd";
	/**
     * 图片名生成
     */
    public static String genImageName() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        //如果不足三位前面补0
        String str = millis + String.format("%03d", end3);

        return str;
    }

    /**
     * 商品id生成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }

    /**
     * UUID
     * @return
     */
    public static String getUUID(){
    	String uuid = UUID.randomUUID().toString();
    	return uuid;
    }
    public static String getUUIDUpperCase(){
        String uuid = UUID.randomUUID().toString();
        return uuid.toUpperCase();
    }
    public static String getClearUUID(){
    	String uuid = getUUID().replace("-", "");
    	return uuid;
    }
    public static String getClearUUIDUpperCase(){
        String uuid = getUUID().replace("-", "");
        return uuid.toUpperCase();
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     }



    public static void main(String[] args) {
        System.out.println(genImageName());
        System.out.println(genItemId());
        System.out.println(getClearUUID());
        System.out.println(getUUIDUpperCase());
        System.out.println(getClearUUIDUpperCase());
        System.out.println(getRandomString(8));
    }
}
