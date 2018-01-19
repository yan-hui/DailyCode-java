package lone.wolf.utils;

public class InfoHiddenUtils {
    /**
     * 身份证号隐藏处理
     *
     * @param idCard
     * @return
     */
    public static String hiddenIdCard(String idCard) {
        String regex = "(\\S{4})\\S{11}(\\S{3})";
        idCard = idCard.replaceAll(regex, "$1*****$2");
        return idCard;
    }

    /**
     * 电话号码隐藏处理
     *
     * @param phoneNumber
     * @return
     */
    public static String hiddenPhone(String phoneNumber) {
        String regex = "(\\S{3})\\S{5}(\\S{3})";
        phoneNumber = phoneNumber.replaceAll(regex, "$1*****$2");
        return phoneNumber;
    }

    public static void main(String[] args) {
        String str = "123456789987654321";
        String regex = "(\\S{4})\\S{11}(\\S{3})";
        String result = str.replaceAll(regex, "$1*****$2");
        System.out.println(result);
        System.out.println(hiddenIdCard(str));
        String phone = "12345678911";
        System.out.println(hiddenPhone(phone));
    }
}
