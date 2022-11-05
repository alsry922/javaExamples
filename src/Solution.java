import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {
    public static void main(String[] args) {
        String[] strArr = {"ccc", "bbb", "aaa"};
        List<String> strList = Arrays.asList(strArr);

        System.out.println("=== 배열로부터 만든 스트림 정렬 결과 ===");
        Stream<String> stream1 = Arrays.stream(strArr);        // 배열로 스트림 생성
        stream1.sorted().forEach(System.out::println);        // 스트림을 이용하여 데이터를 정렬하고 콘솔에 출력
        System.out.println("=== 배열로부터 만든 스트림 정렬 결과 ===");
        System.out.println();

        System.out.println("=== 리스트로부터 만든 스트림 정렬 결과 ===");
        Stream<String> stream2 = strList.stream();         //리스트로 스트림 생성
        stream2.sorted().forEach(System.out::println);        // 스트림을 이용하여 데이터를 정렬하고 콘솔에 출력
        System.out.println("=== 리스트로부터 만든 스트림 정렬 결과 ===");
        System.out.println();

        System.out.println("=== 원래 데이터 소스 ===");
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));
        System.out.println("strList = " + strList);
        System.out.println("=== 원래 데이터 소스 ===");
        System.out.println();

        System.out.println("=== 리스트로 스트림 만들기 ===");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> integerStream = list.stream();
        integerStream.forEach(System.out::println);
        System.out.println("=== 리스트로 스트림 만들기 ===");
        System.out.println();

        System.out.println("=== 배열로부터 스트림 만들기 ===");
        int[] intArr = new int[]{1,2,3};
//        Stream<int[]> intArrStream1 = Stream.of(intArr);
        IntStream intArrStream1 = Arrays.stream(intArr);
        IntStream intArrStream2 = IntStream.of(intArr);
        intArrStream1.forEach(System.out::println);
        intArrStream2.forEach(System.out::println);
        System.out.println("=== 배열로부터 스트림 만들기");
        System.out.println();

        System.out.println("=== 스트림 연결하기 ===");
        String[] str1 = {"123", "456", "789"};
        String[] str2 = {"ABC", "abc", "DEF"};

        Stream<String> stringStream1 = Stream.of(str1);
        Stream<String> stringStream2 = Arrays.stream(str2);
        Stream<String> stringStream3 = Stream.concat(stringStream1, stringStream2);
        stringStream3.forEach(System.out::println);
        System.out.println("=== 스트림 연결하기 ===");

        System.out.println("=== Integer 스트림을 String 스트림으로 변환하기 ===");
//        List<int[]> ints = Arrays.asList(intArr); // 참조값을 가지는 배열로 asList()를 호출하자
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream()
            .map(i -> Integer.toString(i))
            .forEach(s -> System.out.println(s + " " + s.getClass()));
        System.out.println("=== Integer 스트림을 String 스트림으로 변환하기 ===");
        System.out.println();

        System.out.println("=== peek으로 조회해보기 ===");
        integerList.stream()
            .peek(i -> System.out.println(i + " " + i.getClass()))
            .forEach(i -> System.out.println(i + " " + i.getClass()));
        System.out.println("=== peek으로 조회해보기 ===");


    }
}

