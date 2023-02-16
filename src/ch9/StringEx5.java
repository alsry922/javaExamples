package ch9;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

public class StringEx5 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "가";

        byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
        byte[] cp949s = str.getBytes("CP949");

        System.out.println("joinByteArr(utf8) = " + joinByteArr(utf8));
        System.out.println("joinByteArr(cp949s) = " + joinByteArr(cp949s));

        System.out.println("new String(utf8, \"utf-8\") = " + new String(utf8, "utf-8"));
        System.out.println("new String(cp949s, \"cp949\") = " + new String(cp949s, "cp949"));

    }

    private static String joinByteArr(byte[] bytes) {
        StringJoiner stringJoiner = new StringJoiner(":", "[", "]");
        for (byte aByte : bytes) {
            System.out.println("aByte = " + aByte);
            stringJoiner.add(String.format("%02X", aByte));
        }
        return stringJoiner.toString();
    }
}
