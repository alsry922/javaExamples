package ch9;

import java.util.StringJoiner;

public class StringEx4 {
    public static void main(String[] args) {
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");

        System.out.println(String.join(",",arr));

        StringJoiner stringJoiner = new StringJoiner("/", "[", "]");
        for (String s : arr) {
            stringJoiner.add(s);
        }
        System.out.println( stringJoiner.toString());
    }
}
