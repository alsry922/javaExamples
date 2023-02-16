package ch9;

public class WrapperEx3 {
    public static void main(String[] args) {
        int i = 10;

        //기본형을 참조형으로 형변환
        //Integer intg = (Integer)i;
        //형변환 생략 가능
        Integer intg = i; // Integer intg = Integer.valueOf(i);
        Object obj = i; // Object obj = (Object)Integer.valueOf(i);

        Long lng = 100L;

        int i2 = intg + 10;
        long l = intg + lng;

        Integer intg2 = Integer.valueOf(20);
        int i3 = (int)intg2; // 형변환 생략 가능

        Integer intg3 = intg2 + i3;

        System.out.println("i = " + i);
        System.out.println("intg = " + intg);
        System.out.println("obj = " + obj);
        System.out.println("lng = " + lng);
        System.out.println("intg + 10 = " + i2);
        System.out.println("intg + lng = " + l);
        System.out.println("i3 = " + i3);
        System.out.println("intg3 = " + intg3);
    }
}
