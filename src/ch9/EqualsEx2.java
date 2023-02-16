package ch9;

public class EqualsEx2 {
    static class Person {
        long id;

        public Person(long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Person) {
                return id == ((Person) obj).id;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person(1122334455);
        Person person2 = new Person(1122334455);
        if (person1 == person2) {
            System.out.println("p1과 p2는 같은 사람입니다.");
        } else {
            System.out.println("p1과 p2는 다른 사람입니다.");
        }

        if (person1.equals(person2)) {
            System.out.println("p1과 p2는 같은 사람입니다.");
        } else {
            System.out.println("p1과 p2는 다른 사람입니다.");
        }
    }
}
