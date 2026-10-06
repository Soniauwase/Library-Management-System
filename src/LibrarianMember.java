public class LibrarianMember extends Member {

        public LibrarianMember(String member_id, String member_category, String contact_info) {
            super(member_id, member_category, contact_info);
        }

    @Override
    public double calculateFees(int overDueDays) {
        return 0.0;
    }
    }


