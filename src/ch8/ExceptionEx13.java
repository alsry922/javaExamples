package ch8;

public class ExceptionEx13 {
    public static void main(String[] args) {
        method1();
    }
    /*method1에서 예외 발생하고 method1에서 예외 처리*/
    private static void method1() {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("method1 에서 예외가 처리되었음");
            e.printStackTrace();
        }
    }
}
