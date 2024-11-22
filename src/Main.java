import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    //    Необходимо реализовать следующий метод:
////    На вход получаем список названий книг.
//    Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
//    Все книги должны быть отсортированы по алфавиту с первой до последней полки.
//    Количество полок константное — 5 штук.
//    Вернуть книги, распределенные по полкам.
    public static void main(String[] args) {
        List<String> books = new ArrayList<>(Arrays.asList());
        books.add("Books01");
        books.add("Books02");
        books.add("Books03");
        books.add("Books04");
        books.add("Books05");
        books.add("Books06");
        books.add("Books07");
        books.add("Books08");
        books.add("Books09");
        books.add("Books10");
        books.add("Books12");
        books.add("Books11");
        books.add("Books13");
        books.add("Books15");
        books.add("Books14");

        System.out.println(books.toString());
        System.out.println("getShelvesOnBooks(books) = " + getShelvesOnBooks(books).toString());
    }

    public static List<List<String>> getShelvesOnBooks(List<String> books) {
        final int NUMBER_OF_SHELVES = 5;
        List<String> sortedBooks = books.stream()
                .sorted()
                .toList();
        List<List<String>> shelves = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_SHELVES; i++) {
            shelves.add(new ArrayList());
        }
        int i = 0;
        int placeShelve = ((books.size() + (shelves.size() - 1)) / shelves.size());
        for (List<String> shelve : shelves) {
            for (int j = 0; j < placeShelve; j++) {
                int numberBook = i * placeShelve + j;
                if (numberBook < books.size()) {
                    shelves.get(i).add(sortedBooks.get(numberBook));
                }
            }
            i++;
        }
        return shelves;
    }
}