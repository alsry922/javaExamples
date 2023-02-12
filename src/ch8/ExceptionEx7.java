package ch8;

public class ExceptionEx7 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0 / 0);
            // 실행되지 않음
            System.out.println(4);
            //ArithmeticException이 발생했지만 Exception클래스의 하위 클래스이므로
            // 해당 catch블럭에서 예외 처리가 진행된다.
        } catch (ArithmeticException ae) {
            if (ae instanceof ArithmeticException) {
                System.out.println(true);
            }
            System.out.println("ArithmeticException");
            //ArithmeticException이 발생해서 위의 catch블럭을 통해 예외 처리가 이루어지면
            // 해당 catch블럭은 실행되지 않는다.
            // ArithmeticException을 제외한 예외들이 해당 catch블럭을 통해 예외 처리가 이루어진다.
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(6);
    }
}
