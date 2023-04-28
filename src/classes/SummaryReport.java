package classes;
import java.util.*;
public class SummaryReport {

    // initializing fields
    private ArrayList<String> providerNames;
    private ArrayList<Integer> providerConsultNums;
    private ArrayList<Integer> providerTotalFees;
    private int amountOfProviders;
    private int amountOfConsults;
    private int totalFee;

    // default constructor does not intialize any values
    public SummaryReport() {

    }
    
    // Constructor that provides all fields of the report
    public SummaryReport(ArrayList<String> providerNames, ArrayList<Integer> providerConsultNums, ArrayList<Integer> providerTotalFees,
            int amountOfProviders, int amountOfConsults, int totalFee) {
        this.providerNames = providerNames;
        this.providerConsultNums = providerConsultNums;
        this.providerTotalFees = providerTotalFees;
        this.amountOfProviders = amountOfProviders;
        this.amountOfConsults = amountOfConsults;
        this.totalFee = totalFee;
    }

    // getters and setters
    public ArrayList<String> getProviderNames() {
        return providerNames;
    }

    public void setProviderNames(ArrayList<String> providerNames) {
        this.providerNames = providerNames;
    }

    public ArrayList<Integer> getProviderConsultNums() {
        return providerConsultNums;
    }

    public void setProviderConsultNums(ArrayList<Integer> providerConsultNums) {
        this.providerConsultNums = providerConsultNums;
    }

    public ArrayList<Integer> getProviderTotalFees() {
        return providerTotalFees;
    }

    public void setProviderTotalFees(ArrayList<Integer> providerTotalFees) {
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

    @Override
    public String toString() {
        return "SummaryReport [providerNames=" + providerNames + ", providerConsultNums=" + providerConsultNums
                + ", providerTotalFees=" + providerTotalFees + ", amountOfProviders=" + amountOfProviders
                + ", amountOfConsults=" + amountOfConsults + ", totalFee=" + totalFee + "]";
    }
    
}