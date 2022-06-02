package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import library.models.Author;
import library.models.Book;
import library.models.Gender;

public class App{
    public static void main(String[] args) {
        List<Book> library = getBooks.get();

        List<String> names =  library.stream()
            .map(Book::getAuthor)
            .filter(greatThan50)
            .distinct()
            .limit(15)
            .map(Author::getSurname)
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        names.forEach(name -> System.out.printf("Surname from author greather than 50: %s\n", name));

        Integer sumAge = library.stream()
            .map(Book::getAuthor)
            .filter(isFemale)
            .map(Author::getAge)
            .filter(lessThan25)
            .reduce(0, Integer::sum);

        System.out.printf("\nSum of the age from Female author with age smaller than 25: %d\n",sumAge);
    }

    static Predicate<Author> greatThan50 = a -> a.getAge() >= 50;

    static Predicate<Integer> lessThan25 = i -> i < 25;
    
    static Predicate<Author> isFemale = a -> Gender.FEMALE.equals(a.getGender());

    static Supplier<List<Book>> getBooks = () -> List.of(
            new Book(new Author("Smith",Gender.MALE, 22)),
            new Book(new Author("Jackson",Gender.FEMALE, 31)),
            new Book(new Author("Lee",Gender.FEMALE, 29)),
            new Book(new Author("Lopez",Gender.FEMALE, 19)),
            new Book(new Author("Carlson",Gender.MALE, 41)),
            new Book(new Author("Carrol",Gender.FEMALE, 54)),
            new Book(new Author("Ruiz",Gender.FEMALE, 20)),
            new Book(new Author("Stephenson",Gender.MALE, 45)),
            new Book(new Author("Ryan",Gender.FEMALE, 64)),
            new Book(new Author("Mendoza",Gender.MALE, 21)),
            new Book(new Author("Reyes",Gender.MALE, 60)),
            new Book(new Author("Giggs",Gender.FEMALE, 48)),
            new Book(new Author("Yang",Gender.MALE, 33)),
            new Book(new Author("Louis",Gender.FEMALE, 27)),
            new Book(new Author("Gomez",Gender.MALE, 25))
        );
    
}