package ch9;

public class CardToString {
    static class Card {
        String kind;
        int number;

        public Card(String kind, int number) {
            this.kind = kind;
            this.number = number;
        }

        public Card() {
            this("Space", 1);
        }
    }

    public static void main(String[] args) {
        Card card1 = new Card();
        Card card2 = new Card();

        System.out.println("card1.toString() = " + card1.toString());
        System.out.println("card2.toString() = " + card2.toString());
    }
}
