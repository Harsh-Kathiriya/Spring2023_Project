
class ProviderReport {
    // initializing fields
    private String providerName;
    private int providerNumber;
    private String providerAddress;
    private String providerCity;
    private String providerState;
    private int providerZipCode;
    private int consultNum;
    private double totalFee;

    // default constructor does not intialize any values
    ProviderReport() {

    }

    // Constructor that provides all fields of the report
    ProviderReport(String providerName, int providerNumber, String providerAddress, String providerCity,
            String providerState, int providerZipCode, int consultNum, double totalFee) {
        this.providerName = providerName;
        this.providerNumber = providerNumber;
        this.providerAddress = providerAddress;
        this.providerCity = providerCity;
        this.providerState = providerState;
        this.providerZipCode = providerZipCode;
        this.consultNum = consultNum;
        this.totalFee = totalFee;
    }

    // getters and setters
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getProviderNumber() {
        return providerNumber;
    }

    public void setProviderNumber(int providerNumber) {
        this.providerNumber = providerNumber;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderCity() {
        return providerCity;
    }

    public void setProviderCity(String providerCity) {
        this.providerCity = providerCity;
    }

    public String getProviderState() {
        return providerState;
    }

    public void setProviderState(String providerState) {
        this.providerState = providerState;
    }

    public int getProviderZipCode() {
        return providerZipCode;
    }

    public void setProviderZipCode(int providerZipCode) {
        this.providerZipCode = providerZipCode;
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