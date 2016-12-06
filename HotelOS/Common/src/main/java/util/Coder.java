package util;

/**
 * Created by Hiki on 12/6/2016.
 */
public class Coder {

    private final static int codeBit = 121;

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
