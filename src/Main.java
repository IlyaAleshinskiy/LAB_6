public class Main {
    public static void main(String[] args) {
        Person[] people = {new Student(), new Professor()};

        Visitor session = new Session();
        Visitor vacation = new Vacation();
        Visitor attestation = new Attestation();

        System.out.println("Во время сессии:");
        for (Person person : people) {
            person.accept(session);
        }

        System.out.println("\nВо время каникул:");
        for (Person person : people) {
            person.accept(vacation);
        }

        System.out.println("\nВо время аттестации:");
        for (Person person : people) {
            person.accept(attestation);
        }
    }
}