import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class LibraryRepository<T> implements Repository<T> {
    private List<T> items = new ArrayList<>();
    private Function<T, String> idExtractor;

    public LibraryRepository(Function<T, String> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public void save(T item) {
        items.add(item);
    }

    @Override
    public Optional<T> findById(String id) {
        for (T item : items) {
            if (idExtractor.apply(item).equalsIgnoreCase(id)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public void addAllFromSource(List<? extends T> source) {
        for (T item : source) {
            items.add(item);
        }
    }

    @Override
    public void copyToDestination(List<? super T> destination) {
        destination.addAll(items);
    }

    public static void printBookTitles(List<? extends Book> books) {
        for (Book book : books) {
            System.out.println("Title: " + book.getBook_name());
        }
    }


};