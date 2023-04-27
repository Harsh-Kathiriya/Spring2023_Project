import java.sql.Date;
import java.util.*;

class MemberReport {
    // initializing fields
    private static String memberName;
    private static String memberNumber;
    private static String memberAddress;
    private static String memberCity;
    private static String memberState;
    private static String memberZipCode;
    private ArrayList<Integer> dateOfServices;
    private ArrayList<String> providerNames;
    private ArrayList<String> serviceNames;

    // default constructor does not intialize any values
    MemberReport() {

    }

    // Constructor that provides all fields of the report
    MemberReport(String memberName, String memberNumber, String memberAddress, String memberCity,
            String memberState, String memberZipCode, ArrayList<Integer> dateOfServices,
            ArrayList<String> providerNames,
            ArrayList<String> serviceNames) {
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
    public static String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public static String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public static String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public static String getMemberCity() {
        return memberCity;
    }

    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }

    public static String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }

    public static String getMemberZipCode() {
        return memberZipCode;
    }

    public void setMemberZipCode(String memberZipCode) {
        this.memberZipCode = memberZipCode;
    }

    public ArrayList<Integer> getDateOfServices() {
        return dateOfServices;
    }

    public void setDateOfServices(ArrayList<Integer> dateOfServices) {
        this.dateOfServices = dateOfServices;
    }

    public ArrayList<String> getProviderNames() {
        return providerNames;
    }

    public void setProviderNames(ArrayList<String> providerNames) {
        this.providerNames = providerNames;
    }

    public ArrayList<String> getServiceNames() {
        return serviceNames;
    }

    public void setServiceNames(ArrayList<String> serviceNames) {
        this.serviceNames = serviceNames;
    }
}