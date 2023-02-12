package ch8;

public class ExceptionEx14 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("main 메서드에서 예외가 처리되었음");
            e.printStackTrace();
        }
    }
    /*method1에서 예외가 발생하였지만 main에서 예외가 처리됨*/
    private static void method1() throws Exception{
        throw new Exception();
    }
}
