package lone.wolf.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 正则工具类
 * @Author hechunhui
 * @CreatedBy 2018/11/12 15:22
 */
public class RegexUtils {


    /**
     * 获取匹配a标签的内容
     * @param content 内容
     * @return 所有的超链接
     */
    public static List<String> getLink(String content) {
        String regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>";
        final List<String> list = new ArrayList<>();
        final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
        final Matcher ma = pa.matcher(content);
        while (ma.find()) {
            list.add(ma.group());
        }
        return list;
    }


    /**
     * 获取匹配正则表达式的内容
     * @param content 内容
     * @param regex 正则表达式
     * @return 匹配正则表达式的内容
     */
    public static List<String> getContentByRegex(String content, String regex) {
        final List<String> list = new ArrayList<>();
        // 获得页面所有的链接
        final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
        final Matcher ma = pa.matcher(content);
        while (ma.find()) {
            list.add(ma.group());
        }
        return list;
    }
}
