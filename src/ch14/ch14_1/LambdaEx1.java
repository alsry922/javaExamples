package ch14.ch14_1;

import java.io.File;
import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface MyFunction1 {
  void run();
}

class LambdaEx1 {
  static void execute(MyFunction1 f) {
    f.run();
  }

  static MyFunction1 getMyFuntion() {
    MyFunction1 f = () -> System.out.println("f3.run()");
    return f;
  }

  public static void main(String[] args) {
    MyFunction1 f1 = () -> System.out.println("f1.run()");

    MyFunction1 f2 = new MyFunction1() {
      public void run() {
        System.out.println("f2.run()");
      }
    };

    MyFunction1 f3 = getMyFuntion();

    f1.run();
    f2.run();
    f3.run();
    execute(f1);
    execute(() -> System.out.println("run()"));
  }
}
class LambdaEx2 {
  public static void main(String[] args) {
    MyFunction1 f = () -> {};
    Object obj = (MyFunction1)() ->{};
    String str = ((Object)(MyFunction1)() -> {}).toString();
    System.out.println("f = " + f);
    System.out.println("obj = " + obj);
    System.out.println("str = " + str);

    System.out.println((MyFunction1)()->{});
    System.out.println(((Object) (MyFunction1)()->{}).toString());
  }
}

@FunctionalInterface
interface MyFunction2 {
  void myMethod();
}

class Outer {
  int val = 10;
  class Inner {
    int val = 20;

    void method(int i) {
      int val = 30;

      MyFunction2 f = () -> {
        System.out.println("i = " + i);
        System.out.println("val = " + val);
        System.out.println("this.val = " + ++this.val);
        System.out.println("Outer.this.val = " + ++Outer.this.val);
      };
      f.myMethod();
    }
  }
}

class lambdaEx3 {
  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    inner.method(100);
  }
}

class LambdaEx4 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i< 10; i++) {
      list.add(i);
    }
    list.forEach(i -> System.out.print(i+ ", "));
    System.out.println();

    list.removeIf(x -> x%2 == 0 || x % 3 == 0);
    System.out.println(list);

    list.replaceAll(i -> i*10);
    System.out.println(list);

    Map<String, String> map = new HashMap<>();
    map.put("1", "1");
    map.put("2", "2");
    map.put("3", "3");
    map.put("4", "4");

    map.forEach((k, v) -> System.out.print("{" + k + "," + v + "},"));
    System.out.println();
  }
}

class LambdaEx5 {
  public static void main(String[] args) {
    Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
    Consumer<Integer> c = i -> System.out.print(i + ", ");
    Predicate<Integer> p = i -> i % 2 == 0;
    Function<Integer, Integer> f = i -> i / 10 * 10;

    List<Integer> list = new ArrayList<>();
    makeRandomList(s, list);
    System.out.println(list);
    printEvenNum(p, c, list);
    List<Integer> newList = doSomething(f, list);
    System.out.println(newList);
  }

  static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
    List<T> newList = new ArrayList<T>(list.size());
    for (T i : list) {
      newList.add(f.apply(i));
    }
    return newList;
  }

  static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
    System.out.print("[");
    for (T i : list) {
      if (p.test(i)) {
        c.accept(i);
      }
    }
    System.out.println("]");
  }

  static <T> void makeRandomList(Supplier<T> s, List<T> list) {
    for (int i = 0; i < 10; i++) {
      list.add(s.get());
    }
  }
}

class LambdaEx6 {
  public static void main(String[] args) {
    IntSupplier s = () -> (int) (Math.random() * 100) + 1;
    IntConsumer c = i -> System.out.print(i + ", ");
    IntPredicate p = i -> i % 2 == 0;
    IntUnaryOperator op = i -> i / 10 * 10;

    int[] arr = new int[10];

    makeRandomList(s, arr);
    System.out.println(Arrays.toString(arr));
    printEvenNum(p, c, arr);
    int[] newArr = doSomething(op, arr);
    System.out.println(Arrays.toString(newArr));
  }

  static void makeRandomList(IntSupplier s, int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = s.getAsInt();
    }
  }

  static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
    System.out.print("[");
    for (int i : arr) {
      if (p.test(i)) {
        c.accept(i);
      }
    }
    System.out.println("]");
  }

  static int[] doSomething(IntUnaryOperator op, int[] arr) {
    int[] newArr = new int[arr.length];
    for (int i = 0; i < newArr.length; i++) {
      newArr[i] = op.applyAsInt(arr[i]);
    }
    return newArr;
  }
}

class LambdaEx7 {
  public static void main(String[] args) {
    Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
    Function<Integer, String> g = Integer::toBinaryString;

    Function<String, String> h = f.andThen(g);
    Function<Integer, Integer> h2 = f.compose(g);

    System.out.println(h.apply("FF"));
    System.out.println(h2.apply(2));

    Function<String, String> f2 = x -> x;
    System.out.println(f2.apply("AAA"));

    Predicate<Integer> p = i -> i < 100;
    Predicate<Integer> q = i -> i < 200;
    Predicate<Integer> r = i -> i % 2 == 0;
    Predicate<Integer> notP = p.negate();

    Predicate<Integer> all = notP.and(q.or(r));
    System.out.println(all.test(150));

    String str1 = "abc";
    String str2 = "abc";

    Predicate<String> p2 = Predicate.isEqual(str1);
    boolean result = p2.test(str2);
    System.out.println(result);
  }
}

class StreamEx2 {
  public static void main(String[] args) {
    File[] fileArr = {
        new File("Ex1.java"),
        new File("Ex1.bak"),
        new File("Ex2.java"),
        new File("Ex1"),
        new File("Ex1.txt")
    };
    Stream<File> fileStream = Stream.of(fileArr);
    Stream<String> fileNameStream = fileStream.map(File::getName);
    fileNameStream.forEach(System.out::println);

    fileStream = Stream.of(fileArr);
    fileStream.map(File::getName)
        .filter(s -> s.indexOf('.') != -1)
        .map(s -> s.substring(s.indexOf('.') + 1))
        .map(String::toUpperCase)
        .distinct()
        .forEach(System.out::println);
  }
}

class StreamEx3 {
  public static void main(String[] args) {
    Student[] stuArr = {
        new Student("이자바", 3, 300),
        new Student("김자바", 1, 200),
        new Student("안자바", 2, 100),
        new Student("박자바", 2, 150),
        new Student("소자바", 1, 200),
        new Student("나자바", 3, 290),
        new Student("감자바", 3, 180),
    };

    Stream<Student> stuStream = Stream.of(stuArr);

    stuStream.sorted(Comparator.comparing(Student::getBan)
                         .thenComparing(Comparator.naturalOrder()))
        .forEach(System.out::println);

    stuStream = Stream.of(stuArr);
    IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);
    IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
    System.out.println("stat.getCount() = " + stat.getCount());
    System.out.println("stat.getSum() = " + stat.getSum());
    System.out.printf("stat.getAverage() = %.2f%n", stat.getAverage());
    System.out.println("stat.getMin() = " + stat.getMin());
    System.out.println("stat.getMax() = " + stat.getMax());
  }
}

class Student implements Comparable<Student> {
  String name;
  int ban;
  int totalScore;

  public Student(String name, int ban, int totalScore) {
    this.name = name;
    this.ban = ban;
    this.totalScore = totalScore;
  }

  public String toString() {
    return String.format("[%s, %d, %d]", name, ban, totalScore);
  }

  public String getName() {
    return name;
  }

  public int getBan() {
    return ban;
  }

  public int getTotalScore() {
    return totalScore;
  }

  @Override
  public int compareTo(Student s) {
    return s.totalScore - this.totalScore;
  }
}

class StreamEx4 {
  public static void main(String[] args) {
    Stream<String[]> strArrStrm = Stream.of(
        new String[]{"abc", "def", "jkl"},
        new String[]{"ABC", "DEF", "JKL"}
    );
    Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

    strStrm.map(String::toLowerCase)
        .distinct()
        .sorted()
        .forEach(System.out::println);
    System.out.println();

    String[] lineArr = {
        "Believe or not It is true",
        "Do or do not There is no try",
    };

    Stream<String> lineStream = Arrays.stream(lineArr);
    lineStream.flatMap(line -> Arrays.stream(line.split(" ")))
        .map(String::toLowerCase)
        .distinct()
        .sorted()
        .forEach(System.out::println);
    System.out.println();

    Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
    Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");
    Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
    Stream<String> strStream = strStrmStrm.map(s -> s.toArray(String[]::new))
                                   .flatMap(Stream::of);
    strStream.map(String::toLowerCase)
        .distinct()
        .forEach(System.out::println);
  }
}

class OptionalEx1 {
  public static void main(String[] args) {
    Optional<String> optStr = Optional.of("abcde");
    Optional<Integer> optInt = optStr.map(String::length);
    System.out.println("optStr.get() = " + optStr.get());
    System.out.println("optInt.get() = " + optInt.get());

    Integer result1 = Optional.of("123")
                          .filter(x -> x.length() > 0)
                          .map(Integer::parseInt)
                          .get();

    Integer result2 = Optional.of("")
                          .filter(x -> x.length() > 0)
                          .map(Integer::parseInt)
                          .orElse(-1);
    System.out.println("result1 = " + result1);
    System.out.println("result2 = " + result2);

    Optional.of("456").map(Integer::parseInt)
        .ifPresent(x -> System.out.printf("result3 = %d%n", x));

    OptionalInt optInt1 = OptionalInt.of(0);
    OptionalInt optInt2 = OptionalInt.empty();

    System.out.println("optInt1.isPresent() = " + optInt1.isPresent());
    System.out.println("optInt2.isPresent() = " + optInt2.isPresent());
    System.out.println("optInt1.getAsInt() = " + optInt1.getAsInt());
//        System.out.println("optInt2.getAsInt() = " + optInt2.getAsInt()); NoSuchElementException
    System.out.println("optInt1 = " + optInt1);
    System.out.println("optInt2 = " + optInt2);
    System.out.println("optInt1.equals(optInt2) = " + optInt1.equals(optInt2));

    Optional<String> opt = Optional.ofNullable(null);
    Optional<String> opt2 = Optional.empty();
    System.out.println("opt = " + opt);
    System.out.println("opt2 = " + opt2);
    // Optional 의 equals는 오버라이딩 되어서 Optional 객체의 value 필드를 비교한다.
    System.out.println("opt.equals(opt2) = " + opt.equals(opt2));

    int result3 = optStrToInt(Optional.of("123"), 0);
    int result4 = optStrToInt(Optional.of(""), 0);

    System.out.println("result3 = " + result3);
    System.out.println("result4 = " + result4);
  }

  static int optStrToInt(Optional<String> optStr, int defaultValue) {
    try {
      return optStr.map(Integer::parseInt).get();
    } catch (Exception e) {
      return defaultValue;
    }
  }
}

class StreamEx5 {
  public static void main(String[] args) {
    String[] strArr = {
        "Inheritance", "Java", "Lambda", "Stream",
        "OptionalDouble", "IntStream", "Count", "sum"
    };
    Stream.of(strArr).forEach(System.out::println);

    boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
    System.out.println("noEmptyStr = " + noEmptyStr);
    Optional<String> sWord = Stream.of(strArr)
                                 .filter(s -> s.charAt(0) == 's').findFirst();
    IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
    IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
    IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
    IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
    int count = intStream1.reduce(0, (a, b) -> a + 1);
    int sum = intStream2.reduce(0, Integer::sum);

    OptionalInt max = intStream3.reduce(Integer::max);
    OptionalInt min = intStream4.reduce(Integer::min);
    System.out.println("count = " + count);
    System.out.println("sum = " + sum);
    System.out.println("max = " + max.getAsInt());
    System.out.println("min.getAsInt() = " + min.getAsInt());

  }
}