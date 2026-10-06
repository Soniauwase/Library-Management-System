public class PublisherMember  extends  Member{
    double publisherDailyFee;

    public PublisherMember(String member_id, String member_category, String contact_info, double publisherDailyFee) {
        super(member_id, member_category, contact_info);
        this.publisherDailyFee=publisherDailyFee;
    }

    public double getPublisherDailyFee() {
        return publisherDailyFee;
    }

    public void setPublisherDailyFee(double publisherDailyFee) {
        this.publisherDailyFee = publisherDailyFee;
    }

    @Override
    public double calculateFees(int overDueDays) {
        return (overDueDays* publisherDailyFee);
    }
}
