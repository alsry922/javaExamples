package ch9;

public class ClassEx1 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Card c = new Card("HEART", 3);
        Card c2 = Card.class.newInstance();

        Class<? extends Card> cObj = c.getClass();

        System.out.println(c);
        System.out.println(c2);
        System.out.println("cObj.getName() = " + cObj.getName());
        System.out.println("cObj.toGenericString() = " + cObj.toGenericString());
        System.out.println("cObj.toString() = " + cObj.toString());
    }
}
final class Card {
    String kind;
    int num;

    public Card(String kind, int num) {
        this.kind = kind;
        this.num = num;
    }

    public Card() {
        this("SPADE", 1);
    }

    @Override
    public String toString() {
        return "Card{" +
                "kind='" + kind + '\'' +
                ", num=" + num +
                '}';
    }
}
