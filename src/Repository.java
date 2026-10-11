import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void save(T item);
    Optional<T> findById(String id);
    List<T> findAll();


        void addAllFromSource(List<? extends T> source);
        void copyToDestination(List<? super T> destination);
};

