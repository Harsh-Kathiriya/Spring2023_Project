

class ProviderReport {
    //initializing fields
    private string providerName;
    private int providerNumber;
    private string providerAddress;
    private string providerCity;
    private string providerState;
    private int providerZipCode;
    private int consultNum;
    private double totalFee;

    //default constructor does not intialize any values
    ProviderReport() {

    }

    
    //Constructor that provides all fields of the report
    ProviderReport(string providerName, int providerNumber, string providerAddress, string providerCity, string providerState, int providerZipCode, int consultNum,  double totalFee) {
        this.providerName = providerName;
        this.providerNumber = providerNumber;
        this.providerAddress = providerAddress;
        this.providerCity = providerCity;
        this.providerState = providerState;
        this.providerZipCode = providerZipCode;
        this.consultNum = consultNum;
        this.totalFee = totalFee;
    }


    //getters and setters
    public string getProviderName() {
        return providerName;
    }
    public void setProviderName(string providerName) {
        this.providerName = providerName;
    }
    
    public int getProviderNumber() {
        return providerNumber;
    }
    public void setProviderNumber(int providerNumber) {
        this.providerNumber = providerNumber;
    }
    
    public string getProviderAddress() {
        return providerAddress;
    }
    public void setProviderAddress(string providerAddress) {
        this.providerAddress = providerAddress;
    }
    
    public string getProviderCity() {
        return providerCity;
    }
    public void setProviderCity(string providerCity) {
        this.providerCity = providerCity;
    }
    
    public string getProviderState() {
        return providerState;
    }
    public void setProviderState(string providerState) {
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