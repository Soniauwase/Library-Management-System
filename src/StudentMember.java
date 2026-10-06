public class StudentMember extends  Member{
    private double studentDailyFee;

    public StudentMember(String member_id, String member_category, String contact_info, double studentDailyFee) {
        super(member_id, member_category, contact_info);
        this.studentDailyFee=studentDailyFee;
    }

    public double getStudentDailyFee() {
        return studentDailyFee;
    }

    public void setStudentDailyFee(double studentDailyFee) {
        this.studentDailyFee = studentDailyFee;
    }

    @Override
    public double calculateFees(int overDueDays) {
        return (overDueDays* studentDailyFee);
    }
}
