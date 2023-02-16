package ch9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ObjectsTest {
    public static void main(String[] args) {
        String[][] strings2D1 = {{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] strings2D2 = {{"aaa", "bbb"}, {"AAA", "BBB"}};
        
        System.out.println("==strings2D1==");
        for (String[] strings : strings2D1) {
            System.out.println(Arrays.toString(strings));
        }
        
        System.out.println("==strings2D2==");
        for (String[] strings : strings2D2) {
            System.out.println(Arrays.toString(strings));
        }

        System.out.println("Objects.equals(strings2D1, strings2D1) = " + Objects.equals(strings2D1, strings2D2));
        System.out.println("Objects.deepEquals(strings2D1, strings2D2) = " + Objects.deepEquals(strings2D1, strings2D2));
        System.out.println("Objects.isNull(null) = " + Objects.isNull(null));
        System.out.println("Objects.nonNull() = " + Objects.nonNull(null));
        System.out.println("Objects.hashCode(null) = " + Objects.hashCode(null));
        System.out.println("Objects.toString(null) = " + Objects.toString(null));
        System.out.println("Objects.toString(null, \"\") = " + Objects.toString(null, ""));

        Comparator<String> caseInsensitiveOrder = String.CASE_INSENSITIVE_ORDER;
        System.out.println("compare(\"aa\",\"bb\", caseInsensitiveOrder) = " + Objects.compare("aa","bb",caseInsensitiveOrder));
        System.out.println("Objects.compare(\"ab\", \"AB\", caseInsensitiveOrder) = " + Objects.compare("ab", "AB", caseInsensitiveOrder));
        System.out.println("Objects.compare(\"ab\", \"AB\", caseInsensitiveOrder) = " + Objects.compare("ab", "AB", caseInsensitiveOrder));
    }
}
