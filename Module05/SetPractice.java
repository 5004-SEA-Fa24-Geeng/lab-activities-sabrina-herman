import java.util.HashSet;
import java.util.Set;


// Practice using sets in Java


public class SetPractice {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Alice");
        set.add("Bob");
        set.add("Carol");

        System.out.println(set);

        set.add("Alice"); // what will happen?

        System.out.println(set.contains("Alice"));


        // TODO: add Set<Person>, and see
        // how it behaves with both students and person.
        // Make sure to have a duplicate student or person
        Set<Person> people = new HashSet<>();
        Person p1 = new Person("Alice");
        Person p2 = new Student("Alice", 1);
        Person p3 = new Student("Alice", 2);
        Person p4 = new Student("Alice", 1); // same as p2?

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        System.out.println(people);
        System.out.println(people.size());




    }

}
