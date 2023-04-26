import java.sql.Date;

class MemberReport {
    // initializing fields
    private String memberName;
    private String memberNumber;
    private String memberAddress;
    private String memberCity;
    private String memberState;
    private String memberZipCode;
    private int dateOfServices[];
    private String providerNames[];
    private String serviceNames[];

    // default constructor does not intialize any values
    MemberReport() {

    }

    // Constructor that provides all fields of the report
    MemberReport(String memberName, String memberNumber, String memberAddress, String memberCity,
            String memberState, String memberZipCode, int dateOfServices[], String providerNames[],
            String serviceNames[]) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberAddress = memberAddress;
        this.memberCity = memberCity;
        this.memberState = memberState;
        this.memberZipCode = memberZipCode;
        this.dateOfServices = dateOfServices;
        this.providerNames = providerNames;
        this.serviceNames = serviceNames;
    }

    // getters and setters
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
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

    public String getMemberZipCode() {
        return memberZipCode;
    }

    public void setMemberZipCode(String memberZipCode) {
        this.memberZipCode = memberZipCode;
    }

    public int[] getDateOfServices() {
        return dateOfServices;
    }

    public void setDateOfServices(int[] dateOfServices) {
        this.dateOfServices = dateOfServices;
    }

    public String[] getProviderNames() {
        return providerNames;
    }

    public void setProviderNames(String[] providerNames) {
        this.providerNames = providerNames;
    }

    public String[] getServiceNames() {
        return serviceNames;
    }

    public void setServiceNames(String[] serviceNames) {
        this.serviceNames = serviceNames;
    }
}