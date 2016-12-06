package util;

/**
 * Created by Hiki on 12/6/2016.
 * Desciption：加密/解密方法，用简单的异或实现
 */
public class Coder {

    // 转换位（加密规则，不可更改）
    private final static int codeBit = 520;

    // 加密
    public static String encode(String input) {
        char[] chars = input.toCharArray();
        for(char i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] ^ codeBit);
        }
        return String.valueOf(chars);
    }

    // 解密
    public static String decode(String input) {
        char[] chars = input.toCharArray();
        for(char i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] ^ codeBit);
        }
        return String.valueOf(chars);
    }

}
