import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SabrinaHermanSolution {
    public static List<Integer> even(List<Integer> list) {
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                even.add(list.get(i));
            }
        }
        return even;
    }
    public static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    public static List<Integer> square(List<Integer> numbers) {
        List<Integer> square = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            square.add(numbers.get(i) * numbers.get(i));
        }
        return square;
    }

    public static List<Book> listOfBooks(List<String> books) {
        List<Book> bookList = new ArrayList<>();
        for (String book : books) {
            Book newBook = Book.createFromString(book);
            bookList.add(newBook);
        }
        return bookList;
    }



    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // this function is a quick way to build a list
        List<Integer> evens2 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens2);

        List<Integer> evenList = even(numbers);
        System.out.println(evenList);

        int sum = getSum(numbers);
        System.out.println(sum);

        List<Integer> squaredList = square(numbers);
        System.out.println(squaredList);

        List<String> bookStrings = Arrays.asList("The Great Gatsby,F. Scott Fitzgerald,1925",
                "To Kill a Mockingbird,Harper Lee,1960",
                "1984,George Orwell,1949",
                "The Catcher in the Rye,J.D. Salinger,1951",
                "Beloved,Toni Morrison,1987");
        List<Book> books = listOfBooks(bookStrings);
        System.out.println(books);

        List<Book> sortedBooks = books.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedBooks);

    }
}