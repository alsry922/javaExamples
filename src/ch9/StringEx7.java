package ch9;

public class StringEx7 {
    public static void main(String[] args) {
        String fullName = "Hello.java";

        int index = fullName.indexOf(".");

        String fileName = fullName.substring(0, index);

        String ext = fullName.substring(index + 1);
        System.out.println("fileName = " + fileName);
        System.out.println("ext = " + ext);
    }
}
