public class ManagerController {

  // Set Report Type
  int reportType;

  public void setReportType(int reportType) {
    // 1 is Summary
    // 2 is EFT
    // 3 is Provider
    // 4 is Member
    this.reportType = reportType;
  }

  // Provider Variables
  private String providerName;
  private int providerNumber;
  private String providerAddress;
  private String providerCity;
  private String providerState;
  private int providerZipCode;
  private int consultNum;
  private double totalFee;

  // Provider Getters and Setters
  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  public void setProviderNumber(int providerNumber) {
    this.providerNumber = providerNumber;
  }

  public void setProviderAddress(String providerAddress) {
    this.providerAddress = providerAddress;
  }

  public void setProviderCity(String providerCity) {
    this.providerCity = providerCity;
  }

  public void setProviderState(String providerState) {
    this.providerState = providerState;
  }

  public void setProviderZipCode(int providerZipCode) {
    this.providerZipCode = providerZipCode;
  }

  public void setConsultNum(int consultNum) {
    this.consultNum = consultNum;
  }

  public void setTotalFee(double totalFee) {
    this.totalFee = totalFee;
  }

  public String getProviderName() {
    return providerName;
  }

  public int getProviderNumber() {
    return providerNumber;
  }

  public String getProviderAddress() {
    return providerAddress;
  }

  public String getProviderCity() {
    return providerCity;
  }

  public String getProviderState() {
    return providerState;
  }

  public int getProviderZipCode() {
    return providerZipCode;
  }

  public int getConsultNum() {
    return consultNum;
  }

  public double getTotalFee() {
    return totalFee;
  }

  public void getProviderReport(String providerName, int providerNumber, String providerAddress,
      String providerCity, String providerState, int providerZipCode, int consultNum, double totalFee) {
    setProviderName(providerName);
    setProviderNumber(providerNumber);
    setProviderAddress(providerAddress);
    setProviderCity(providerCity);
    setProviderState(providerState);
    setProviderZipCode(providerZipCode);
    setConsultNum(consultNum);
    setTotalFee(totalFee);

    if (reportType == 3)

    {
      getProviderName();
      getProviderNumber();
      getProviderAddress();
      getProviderCity();
      getProviderState();
      getProviderZipCode();
      getConsultNum();
      getTotalFee();
    }

  }
}
