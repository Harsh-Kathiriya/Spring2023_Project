package classes;
import java.util.*;

public class ProviderReport {

    // initializing fields
    private  String providerName;
    private  String providerNumber;
    private  String providerAddress;
    private  String providerCity;
    private  String providerState;
    private  String providerZipCode;
    private int consultNum;
    private int totalFee;
    private ArrayList<Integer> fees;
    private ArrayList<Integer> datesOfServices;
    private ArrayList<Integer> datesReceived;
    private ArrayList<String> memberNames;
    private ArrayList<Integer> serviceCodes;
    private ArrayList<Integer> memberNumbers;

    // default constructor does not intialize any values
    ProviderReport() {

    }

    // Constructor that provides all fields of the report
    public ProviderReport(String providerName, String providerNumber, String providerAddress, String providerCity,
            String providerState, String providerZipCode, int consultNum, int totalFee,
            ArrayList<Integer> datesOfServices, ArrayList<Integer> datesReceived, ArrayList<String> memberNames, ArrayList<Integer> memberNumbers,
            ArrayList<Integer> serviceCodes, ArrayList<Integer> fees) {
        this.providerName = providerName;
        this.providerNumber = providerNumber;
        this.providerAddress = providerAddress;
        this.providerCity = providerCity;
        this.providerState = providerState;
        this.providerZipCode = providerZipCode;
        this.consultNum = consultNum;
        this.totalFee = totalFee;
        this.datesOfServices = datesOfServices;
        this.datesReceived = datesReceived;
        this.memberNames = memberNames;
        this.memberNumbers = memberNumbers;
        this.serviceCodes = serviceCodes;
        this.fees = fees;
    }

    // getters and setters
    public  String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public  String getProviderNumber() {
        return providerNumber;
    }

    public void setProviderNumber(String providerNumber) {
        this.providerNumber = providerNumber;
    }

    public  String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public  String getProviderCity() {
        return providerCity;
    }

    public void setProviderCity(String providerCity) {
        this.providerCity = providerCity;
    }

    public  String getProviderState() {
        return providerState;
    }

    public void setProviderState(String providerState) {
        this.providerState = providerState;
    }

    public  String getProviderZipCode() {
        return providerZipCode;
    }

    public void setProviderZipCode(String providerZipCode) {
        this.providerZipCode = providerZipCode;
    }

    public int getConsultNum() {
        return consultNum;
    }

    public void setConsultNum(int consultNum) {
        this.consultNum = consultNum;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public ArrayList<Integer> getDatesOfServices() {
        return datesOfServices;
    }

    public void setDatesOfServices(ArrayList<Integer> datesOfServices) {
        this.datesOfServices = datesOfServices;
    }

    public ArrayList<Integer> getDatesReceived() {
        return datesReceived;
    }

    public void setDatesReceived(ArrayList<Integer> datesReceived) {
        this.datesReceived = datesReceived;
    }

    public ArrayList<String> getMemberNames() {
        return memberNames;
    }

    public void setMemberNames(ArrayList<String> memberNames) {
        this.memberNames = memberNames;
    }

    public ArrayList<Integer> getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(ArrayList<Integer> serviceCodes) {
        this.serviceCodes = serviceCodes;
    }

    public ArrayList<Integer> getFees() {
        return fees;
    }

    public void setFees(ArrayList<Integer> fees) {
        this.fees = fees;
    }
    public ArrayList<Integer> getMemberNumbers() {
        return memberNumbers;
    }

    public void setMemberNumbers(ArrayList<Integer> memberNumbers) {
        this.memberNumbers = memberNumbers;
    }
    @Override
    public String toString() {
        return "ProviderReport \n [providerName=" + providerName + ",\n providerNumber=" + providerNumber
                + ",\n providerAddress=" + providerAddress + ",\n providerCity=" + providerCity + ",\n providerState="
                + providerState + ",\n providerZipCode=" + providerZipCode + ",\n consultNum=" + consultNum + ",\n totalFee="
                + totalFee + ",\n fees=" + fees + ",\n datesOfServices=" + datesOfServices + ",\n datesReceived="
                + datesReceived + ",\n memberNames=" + memberNames + ",\n serviceCodes=" + serviceCodes + ",\n memberNumbers="
                + memberNumbers + "]";
    }
}