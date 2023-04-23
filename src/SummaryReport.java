
class ProviderReport {
    // initializing fields
    private String providerNames[];
    private String providerConsultNums[];
    private int providerTotalFees[];
    private int amountOfProviders;
    private int amountOfConsults;
    private int totalFee;

    // default constructor does not intialize any values
    ProviderReport() {

    }
    
    // Constructor that provides all fields of the report
    public ProviderReport(String[] providerNames, String[] providerConsultNums, int[] providerTotalFees,
            int amountOfProviders, int amountOfConsults, int totalFee) {
        this.providerNames = providerNames;
        this.providerConsultNums = providerConsultNums;
        this.providerTotalFees = providerTotalFees;
        this.amountOfProviders = amountOfProviders;
        this.amountOfConsults = amountOfConsults;
        this.totalFee = totalFee;
    }

    public String[] getProviderNames() {
        return providerNames;
    }

    public void setProviderNames(String[] providerNames) {
        this.providerNames = providerNames;
    }

    public String[] getProviderConsultNums() {
        return providerConsultNums;
    }

    public void setProviderConsultNums(String[] providerConsultNums) {
        this.providerConsultNums = providerConsultNums;
    }

    public int[] getProviderTotalFees() {
        return providerTotalFees;
    }

    public void setProviderTotalFees(int[] providerTotalFees) {
        this.providerTotalFees = providerTotalFees;
    }

    public int getAmountOfProviders() {
        return amountOfProviders;
    }

    public void setAmountOfProviders(int amountOfProviders) {
        this.amountOfProviders = amountOfProviders;
    }

    public int getAmountOfConsults() {
        return amountOfConsults;
    }

    public void setAmountOfConsults(int amountOfConsults) {
        this.amountOfConsults = amountOfConsults;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

   

    

    // getters and setters
    
}