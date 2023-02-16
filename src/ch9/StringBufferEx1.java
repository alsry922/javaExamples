package ch9;

public class StringBufferEx1 {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println("(sb1 == sb2) = " + (sb1 == sb2));
        System.out.println("sb.equals(sb2) = " + sb1.equals(sb2));

        String s = sb1.toString();
        String s2 = sb2.toString();
        System.out.println("s.equals(s2) = " + s.equals(s2));
    }
}
