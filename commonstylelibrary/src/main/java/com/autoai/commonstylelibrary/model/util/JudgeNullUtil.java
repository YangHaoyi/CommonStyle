package com.autoai.commonstylelibrary.model.util;

/**
 * @author : YangHaoYi on 2018/12/7.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/12/7.
 *         Version : V 1.0
 */
public class JudgeNullUtil {
    private JudgeNullUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static boolean isStringNotNull(String string) {
        if (string == null || "null".equals(string) || "".equals(string)) {
            return false;
        }
        return true;
    }

    public static boolean isObjectNotNull(Object object) {
        boolean flag;
        if (null == object) {
            flag = false;
        } else {
            flag = isStringNotNull(String.valueOf(object));
        }
        return flag;
    }
}
