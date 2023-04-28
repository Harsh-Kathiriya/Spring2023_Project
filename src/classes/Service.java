package classes;

public class Service {
    private int currentDate;
    private int dateProvided;
    private int providerNum;
    private int memberNum;
    private int serviceCode;
    private String comments;
    public Service(int currentDate, int dateProvided, int providerNum, int memberNum, int serviceCode) {
        this.currentDate = currentDate;
        this.dateProvided = dateProvided;
        this.providerNum = providerNum;
        this.memberNum = memberNum;
        this.serviceCode = serviceCode;
        this.comments = "NULL";
    }
    public Service(int currentDate, int dateProvided, int providerNum, int memberNum, int serviceCode,
            String comments) {
        this.currentDate = currentDate;
        this.dateProvided = dateProvided;
        this.providerNum = providerNum;
        this.memberNum = memberNum;
        this.serviceCode = serviceCode;
        this.comments = comments;
    }
    public Service() {
    }
    public int getCurrentDate() {
        return currentDate;
    }
    public int getDateProvided() {
        return dateProvided;
    }
    public int getProviderNum() {
        return providerNum;
    }
    public int getMemberNum() {
        return memberNum;
    }
    public int getServiceCode() {
        return serviceCode;
    }
    public String getComments() {
        return comments;
    }
    
}
