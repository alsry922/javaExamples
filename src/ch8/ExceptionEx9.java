package ch8;

public class ExceptionEx9 {
    public static void main(String[] args) {
        try {
            //Exception 인스턴스 생성 시, 생성자에 String을 넣어주면,
            //String이 Exception 인스턴스에 메세지로 저장된다.
            throw new Exception("고의로 발생시킨 예외");
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            //호출스택에 있었던 메서드의 정보와 예외 메세지를 출력
            e.printStackTrace();
        }
    }
}
