package ch8;

public class ExceptionEx2 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;

        for (int i=0; i<10; i++) {
            //정수를 0으로 나누면 ArithmeticException(산술연산과정에서 발생하는 예외)가 발생하며,
            //실수를 0으로 나눌 때는 발생하지 않는다.
            result = number / (int)(Math.random() * 10);
            System.out.println(result);
        }
    }
}