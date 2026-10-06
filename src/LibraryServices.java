import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryServices {

    Map<String, Book> bookMap = new HashMap<>();
    Map<String, Member> memberMap = new HashMap<>();
    Map<String, List<Book>> borrowing = new HashMap<>();

    // registering new member
    public void addNewMember(Member member) {
        memberMap.put(member.getMember_id(), member);
    }

    // registering books
    public void addNewBook(Book book) {
        bookMap.put(book.getBook_id(), book);
    }

    // borrowing book
    public boolean borrowingBook(String member_id, String book_id) {
        Member member = memberMap.get(member_id);
        Book book = bookMap.get(book_id);
        if (member != null && book != null && book.isIs_Available()) {
            book.setIs_Available(false);

            if (!borrowing.containsKey(member_id)) {
                borrowing.put(member.getMember_id(), new ArrayList<>());
            }
            borrowing.get(member_id).add(book);
            return true;
        }
        return false;
    }

    // to calculate the late fee
     public  double calculateLateFees(String member_id, int overDueDays){
         Member member= memberMap.get(member_id);
        if(!(member== null)){
           return  member.calculateFees(overDueDays);
        }
        return 0.0;
     }
     // getters

    public Map<String, Member>getMemberMap(){
        return  memberMap;
    }
    public Map<String, Book>getBookMap(){
        return bookMap;
    }
    public Map<String,List<Book>>getBorrowing(){
        return  borrowing;
    }


};


