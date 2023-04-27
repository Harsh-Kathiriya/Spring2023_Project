//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

public class ManagerController {

  private static final String MEMBER_FILE_NAME = System.getProperty("user.dir") + "/src/Member_Record";
  private static final String PROVIDER_FILE_NAME = System.getProperty("user.dir") + "/src/Provider_Record";

  public static String providerID = "123456789";
  public static String providerName;
  public static String providerNumber;
  public static String providerAddress;
  public static String providerCity;
  public static String providerState;
  public static String providerZipCode;
  public static int consultNum;
  public static double totalFee;
  public static ArrayList<Integer> fees;
  public static ArrayList<Integer> datesOfServices;
  public static ArrayList<Integer> datesReceived;
  public static ArrayList<String> memberNames;
  public static ArrayList<Integer> serviceCodes;

  public static String memberID;
  public static String memberName;
  public static String memberNumber;
  public static String memberAddress;
  public static String memberCity;
  public static String memberState;
  public static String memberZipCode;
  public static ArrayList<Integer> dateOfServices;
  public static ArrayList<String> providerNames;
  public static ArrayList<String> serviceNames;

  static ProviderReport getProviderRecordFromFile(String providerID) throws IOException {
    // Read all the provider records from the file
    List<String> lines = Files.readAllLines(Paths.get(PROVIDER_FILE_NAME));

    // Find the provider record with the given number
    for (String line : lines) {
      if (line.startsWith(providerID + ",")) {
        // Parse the provider record data from the line
        String[] parts = line.split(",");
        String number = parts[0];
        String name = parts[1];
        String address = parts[2];
        String city = parts[3];
        String state = parts[4];
        String zipcode = parts[5];

        // Create a new provider record object with the parsed datae
        providerName = name;
        providerNumber = number;
        providerAddress = address;
        providerCity = city;
        providerState = state;
        providerZipCode = zipcode;
      }
    }

    // If no provider record with the given number was found, return null
    return null;
  }

  static MemberReport getMemberRecordFromFile(String memberID) throws IOException {
    // Read all the member records from the file
    List<String> lines = Files.readAllLines(Paths.get(MEMBER_FILE_NAME));

    // Find the member record with the given number
    for (String line : lines) {
      if (line.startsWith(memberID + ",")) {
        // Parse the member record data from the line
        String[] parts = line.split(",");
        String number = parts[0];
        String name = parts[1];
        String address = parts[2];
        String city = parts[3];
        String state = parts[4];
        String zipcode = parts[5];

        // Create a new member record object with the parsed data
        memberName = name;
        memberNumber = number;
        memberAddress = address;
        memberCity = city;
        memberState = state;
        memberZipCode = zipcode;
      }
    }

    // If no member record with the given number was found, return null
    return null;
  }

  // public static SummaryReport requestSummaryReport() {
  // // for every provider - # num of consults, total fee then total num of
  // // providers, total num of consultations, and total fee
  // ServiceList serviceList = new ServiceList();
  // Service currentService;
  // ArrayList<String> providerNames = new ArrayList<String>();
  // ArrayList<Integer> providerFees = new ArrayList<Integer>();
  // ArrayList<Integer> providerConsults = new ArrayList<Integer>();
  // ProviderReport providerRecord;
  // ProviderDirectory providerDirectory = new ProviderDirectory();
  // int totalFee = 0;

  // try {
  // for (int i = 0; i < serviceList.getSize(); i++) {
  // currentService = serviceList.serviceAt(i);
  // providerRecord =
  // getProviderRecordFromFile(Integer.toString(currentService.getProviderNum()));
  // int serviceFee =
  // providerDirectory.feeLookup(currentService.getServiceCode());
  // totalFee += serviceFee;
  // if (providerNames.contains(providerRecord.getName())) {
  // int currentIndex = providerNames.indexOf(providerRecord.getName());
  // providerFees.set(currentIndex,
  // providerFees.get(providerNames.indexOf(providerRecord.getName()) +
  // serviceFee));
  // providerConsults.set(currentIndex, providerConsults.get(currentIndex) + 1);
  // } else {
  // providerNames.add(providerRecord.getName());
  // providerFees.add(serviceFee);
  // providerConsults.add(1);
  // }
  // }
  // SummaryReport summaryReport = new SummaryReport(providerNames,
  // providerConsults, providerFees,
  // providerNames.size(), serviceList.getSize(), totalFee);
  // return summaryReport;
  // } catch (IOException e) {
  // System.out.println("Error");
  // }
  // return null;
  // }

  public static ProviderReport RequestProviderReport() throws IOException {
    getProviderRecordFromFile(providerID);
    ProviderReport providerReport = new ProviderReport(providerName, providerNumber, providerAddress, providerCity,
        providerState, providerZipCode, consultNum, totalFee, datesOfServices, datesReceived, memberNames, serviceCodes,
        fees);
    // System.out.println("\n");
    // System.out.println(providerReport.getProviderName());
    // System.out.println(providerReport.getProviderNumber());
    // System.out.println(providerReport.getProviderAddress());
    // System.out.println(providerReport.getProviderCity());
    // System.out.println(providerReport.getProviderState());
    // System.out.println(providerReport.getProviderZipCode());
    // System.out.println(providerReport.getConsultNum());
    // System.out.println(providerReport.getTotalFee());
    return providerReport;
  }

  public static SummaryReport RequestSummaryReport() {
    SummaryReport summaryreport = new SummaryReport(providerNames, dateOfServices, fees, consultNum, consultNum,
        consultNum);
    System.out.println("\n");
    // requestSummaryReport();
    System.out.println(summaryreport.getProviderNames());
    return summaryreport;
  }

  public static MemberReport RequestMemberReport() throws IOException {
    getMemberRecordFromFile(memberID);
    MemberReport memberReport = new MemberReport(memberName, memberNumber, memberAddress, memberCity,
        memberState, memberZipCode, dateOfServices, providerNames,
        serviceNames);
    System.out.println("\n");
    System.out.println(memberReport.getMemberName());
    System.out.println(memberReport.getMemberNumber());
    System.out.println(memberReport.getMemberAddress());
    System.out.println(memberReport.getMemberCity());
    System.out.println(memberReport.getMemberState());
    System.out.println(memberReport.getMemberZipCode());
    System.out.println(memberReport.getDateOfServices());
    System.out.println(memberReport.getProviderNames());
    return memberReport;
  }

  public static void main(String[] args) throws IOException {
    RequestProviderReport();
    RequestMemberReport();
    WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
    weeklyAccountingProcedure.requestSummaryReport();
  }
}
