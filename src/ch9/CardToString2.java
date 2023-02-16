package ch9;

public class CardToString2 {
    static class Card {
        String kind;
        int number;

        public Card(String kind, int number) {
            this.kind = kind;
            this.number = number;
        }

        public Card() {
            this("SPADE", 1);
        }

        @Override
        public String toString() {
            return "Card{" +
                    "kind='" + kind + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

    public static void main(String[] args) {
        Card card1 = new Card();
        Card card2 = new Card("HEART", 10);

        System.out.println("card1.toString() = " + card1.toString());
        System.out.println("card2.toString() = " + card2.toString());
    }
}
