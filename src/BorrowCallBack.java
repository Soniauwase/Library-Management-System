@FunctionalInterface
public interface BorrowCallBack<T, M> {
    void onBorrowSuccess(T book, M member);
}
