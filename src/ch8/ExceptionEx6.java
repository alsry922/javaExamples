package ch8;

public class ExceptionEx6 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0);
            // 실행되지 않음
            System.out.println(4);
            //ArithmeticException이 발생했지만 Exception클래스의 하위 클래스이므로
            // 해당 catch블럭에서 예외 처리가 진행된다.
        } catch (Exception e) {
            System.out.println(5);
        }
        System.out.println(6);
    }
}
