import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("Apple", 3.5);
        map.put("Banana", 2.0);
        map.put("Cherry", 4.0);

        // let's print the map

        System.out.println(map);

        // what happens if we add a duplicate key?
        // your code here
        Map<Person, Double> personMap = new HashMap<>();
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob");
        Person p3 = new Person("Charlie");
        Person p4 = new Person("Bob");

        personMap.put(p1, 1.0);
        personMap.put(p2, 2.0);
        personMap.put(p3, 3.0);
        personMap.put(p4, 4.0);

        System.out.println(personMap);

        // now try it with Person/Student. We will
        // use the person or student as a key and the
        // value will be a set of classes they are taking

        Map<Person, Set<String>> classes = new HashMap<>();
        Person p5 = new Person("Alice");
        Person p6 = new Person("Bob");
        Person p7 = new Person("Charlie");
        Person p8 = new Person("Bob");

        classes.put(p5, Set.of("CS5001", "CS5002"));
        classes.put(p6, Set.of("CS5001", "CS5002"));
        classes.put(p7, Set.of("CS5001", "CS5002"));
        classes.put(p8, Set.of("CS5001", "CS5002"));

        System.out.println(classes);
        // you will find Set.of() useful here
        // for example:
        // classes.put(p2, Set.of("CS5001", "CS5002"));

    }

}
