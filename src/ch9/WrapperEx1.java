package ch9;

public class WrapperEx1 {
    public static void main(String[] args) {
        //new 연산자를 통한 Integer객체 생성 Deprecated
        //valueOf() 팩토리 메서드를 통해 생성하는 것이 더 나음
        Integer integer = new Integer(100);
        Integer integer2 = new Integer(100);
//        Integer integer = Integer.valueOf(100);
//        Integer integer2 = Integer.valueOf(100);
        System.out.println("(integer==integer2) = " + (integer == integer2));
        System.out.println("integer.equals(integer2) = " + integer.equals(integer2));
        System.out.println("integer.compareTo(integer2) = " + integer.compareTo(integer2));
        System.out.println("integer.toString() = " + integer.toString());
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE = " + Integer.SIZE+"bits");
        System.out.println("Integer.BYTES = " + Integer.BYTES + "bytes");
        System.out.println("Integer.TYPE = " + Integer.TYPE);

    }
}
