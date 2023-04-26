import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class ManagerController {

  private static final String MEMBER_FILE_NAME = System.getProperty("user.dir") + "/src/Member_Record";
  private static final String PROVIDER_FILE_NAME = System.getProperty("user.dir") + "/src/Provider_Record";

  public static String providerID = "123";
  public static String providerName;
  public static String providerNumber;
  public static String providerAddress;
  public static String providerCity;
  public static String providerState;
  public static String providerZipCode;
  public static int consultNum = 12;
  public static double totalFee = 12;

  public static String memberID = "1234";
  public static String memberName;
  public static String memberNumber;
  public static String memberAddress;
  public static String memberCity;
  public static String memberState;
  public static String memberZipCode;
  public static int dateOfServices[];
  public static String providerNames[];
  public static String serviceNames[];

  public static ProviderRecord getProviderRecordFromFile(String providerID) throws IOException {
    // Read all the provider records from the file
    List<String> lines = Files.readAllLines(Paths.get(PROVIDER_FILE_NAME));

    // Find the provider record with the given number
    for (String line : lines) {
      if (line.startsWith(providerID + ",")) {
        // Parse the provider record data from the line
        String[] parts = line.split(",");
        String name = parts[1];
        String number = parts[2];
        String address = parts[3];
        String city = parts[4];
        String state = parts[5];
        String zipcode = parts[6];

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

  private static MemberRecord getMemberRecordFromFile(String memberID) throws IOException {
    // Read all the member records from the file
    List<String> lines = Files.readAllLines(Paths.get(MEMBER_FILE_NAME));

    // Find the member record with the given number
    for (String line : lines) {
      if (line.startsWith(memberID + ",")) {
        // Parse the member record data from the line
        String[] parts = line.split(",");
        String name = parts[1];
        String number = parts[2];
        String address = parts[3];
        String city = parts[4];
        String state = parts[5];
        String zipcode = parts[6];

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

  public static void RequestProviderReport() throws IOException {
    getProviderRecordFromFile(providerID);
    ProviderReport providerReport = new ProviderReport(providerName, providerNumber, providerAddress, providerCity,
        providerState, providerZipCode, consultNum, totalFee);
    System.out.println("\n");
    System.out.println(providerReport.getProviderName());
    System.out.println(providerReport.getProviderNumber());
    System.out.println(providerReport.getProviderAddress());
    System.out.println(providerReport.getProviderCity());
    System.out.println(providerReport.getProviderState());
    System.out.println(providerReport.getProviderZipCode());
    System.out.println(providerReport.getConsultNum());
    System.out.println(providerReport.getTotalFee());
  }

  public static void RequestSummaryReport() {
    SummaryReport summaryReport = new SummaryReport();
    System.out.println(summaryReport);
  }

  public static void RequestMemberReport() throws IOException {
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
  }

  public static void main(String[] args) throws IOException {
    RequestProviderReport();
    RequestMemberReport();
  }
}
