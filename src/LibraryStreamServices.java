import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryStreamServices {

   public List<Book> findBookByAuthorSorted(Repository<Book>bookRepository, String author){
       return bookRepository.findAll().stream().filter(Book::isIs_Available).filter(book-> book.getAuthor().equalsIgnoreCase(author)).sorted(Comparator.comparing(Book::getBook_name)).collect(Collectors.toList());

   }
    public List<String> getOverdueMemberEmails(Repository<Member> memberRepo, int daysOverdue, double feeThreshold) {
        return memberRepo.findAll().stream()
                .filter(member -> member.calculateFees(daysOverdue) > feeThreshold)
                .map(Member::getContact_info)
                .collect(Collectors.toList());
    }
    public Map<String, List<Member>> groupMembersByType(Repository<Member> memberRepo) {
        return memberRepo.findAll().stream()
                .collect(Collectors.groupingBy(member -> member.getClass().getSimpleName()));
    }
    public double calculateTotalLateFees(Repository<Member> memberRepo, int daysOverdue) {
        return memberRepo.findAll().stream()
                .mapToDouble(member -> member.calculateFees(daysOverdue))
                .sum();
    }
    public void processBorrowRequest(String isbn, String memberId,
                                     Repository<Book> bookRepo,
                                     Repository<Member> memberRepo,
                                     BorrowCallBack<Book, Member> callback) {

        Optional<Book> bookOpt = bookRepo.findById(isbn);
        Optional<Member> memberOpt = memberRepo.findById(memberId);

        if (bookOpt.isPresent() && memberOpt.isPresent()) {
            Book book = bookOpt.get();
            Member member = memberOpt.get();

            if (book.isIs_Available()) {
                book.setIs_Available(false);

                callback.onBorrowSuccess(book, member);
            } else {
                System.out.println("Book is currently unavailable: " + book.getBook_name());
            }
        } else {
            System.out.println("Invalid Book ISBN or Member ID.");
        }
    }
};
