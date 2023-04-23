
class MemberReport {
    // initializing fields
    private String memberName;
    private int memberNumber;
    private String memberAddress;
    private String memberCity;
    private String memberState;
    private int memberZipCode;
    private int consultNum;
    private double totalFee;

    // default constructor does not intialize any values
    MemberReport() {

    }

    // Constructor that provides all fields of the report
    MemberReport(String memberName, int memberNumber, String memberAddress, String memberCity,
            String memberState, int memberZipCode, int consultNum, double totalFee) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberAddress = memberAddress;
        this.memberCity = memberCity;
        this.memberState = memberState;
        this.memberZipCode = memberZipCode;
        this.consultNum = consultNum;
        this.totalFee = totalFee;
    }

    // getters and setters
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberCity() {
        return memberCity;
    }

    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }

    public int getMemberZipCode() {
        return memberZipCode;
    }

    public void setMemberZipCode(int memberZipCode) {
        this.memberZipCode = memberZipCode;
    }

    public int getConsultNum() {
        return consultNum;
    }

    public void setConsultNum(int consultNum) {
        this.consultNum = consultNum;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }
}