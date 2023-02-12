package ch8;

public class ExceptionEx5 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            //의도적으로 0으로 나누어 ArithmeticException을 발생시킨다.
            System.out.println(0/0);
            // 실행되지 않음
            System.out.println(4);
        } catch (ArithmeticException e) {
            System.out.println(5);
        }
        System.out.println(6);
    }
}
