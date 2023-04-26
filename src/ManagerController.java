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

  private static final String MEMBER_FILE_NAME = System.getProperty("user.dir") + "/Member_Record";
  private static final String PROVIDER_FILE_NAME = System.getProperty("user.dir") + "/Provider_Record";

  public static String providerName;
  public static String providerNumber;
  public static String providerAddress;
  public static String providerCity;
  public static String providerState;
  public static String providerZipCode;
  public static int consultNum;
  public static double totalFee;

  public static ProviderRecord getProviderRecordFromFile(String providerNumber) throws IOException {
    // Read all the provider records from the file
    List<String> lines = Files.readAllLines(Paths.get(PROVIDER_FILE_NAME));

    // Find the provider record with the given number
    for (String line : lines) {
      if (line.startsWith(providerNumber + ",")) {
        // Parse the provider record data from the line
        String[] parts = line.split(",");
        String name = parts[0];
        String number = parts[1];
        String address = parts[2];
        String city = parts[3];
        String state = parts[4];
        String zipcode = parts[5];

        // Create a new provider record object with the parsed data
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

  public static void RequestProviderReport() throws IOException {
    getProviderRecordFromFile(PROVIDER_FILE_NAME);
    ProviderReport providerReport = new ProviderReport(providerName, providerNumber, providerAddress, providerCity,
        providerState, providerZipCode, consultNum, totalFee);
    System.out.println(providerReport);
  }

  public static void RequestSummaryReport() {
    SummaryReport summaryReport = new SummaryReport();
    System.out.println(summaryReport);
  }

  public static void RequestMemberReport() {
    MemberReport memberReport = new MemberReport();
    System.out.println(memberReport);
  }
}
