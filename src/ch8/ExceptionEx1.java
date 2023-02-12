package ch8;

public class ExceptionEx1 {
    /*하나의 메서드에 여러 try catch문이 포함될 수 있고
    * try 또는 catch 문 안에 또 다른 try-catch 문이 포함될 수 있다.*/
    public static void main(String[] args) {
        try {
            try {} catch (Exception e) {}
        } catch (Exception e) {
            try {} catch (Exception ex) {}
        }
        try {

        }catch (Exception e) {

        }
    }
}

















