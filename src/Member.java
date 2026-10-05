import java.util.ArrayList;
import java.util.List;

public  abstract class Member {
    private String member_id;
    private String member_category;
    private String contact_info;
    private List<Book> borrowedBooks;

    public Member(String member_id, String member_category, String contact_info) {
        this.member_id = member_id;
        this.member_category = member_category;
        this.contact_info = contact_info;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_category() {
        return member_category;
    }

    public void setMember_category(String member_category) {
        this.member_category = member_category;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    @Override
    public String toString() {
        return "Members{" +
                "member_id='" + member_id + '\'' +
                ", member_category='" + member_category + '\'' +
                ", contact_info='" + contact_info + '\'' +
                '}';


    }
     public  abstract  double calculateGrade( int overDueDays);
}

