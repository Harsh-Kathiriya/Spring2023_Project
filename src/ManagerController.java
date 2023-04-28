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
  ServiceList serviceList;
  providerRecordHash ProviderRecordHash;
  ProviderDirectory providerDirectory;
  MemberRecordHash memberRecordHash;
  ManagerController() {
      try {
          providerDirectory = new ProviderDirectory();
          serviceList = new ServiceList();
          ProviderRecordHash = new providerRecordHash();
          System.out.println("Working");
          memberRecordHash = new MemberRecordHash();
      }
      catch(Exception e) {
          System.out.println(e.getStackTrace());
      }
  }
  /**
   * {@summary A helper method that gets a provider record from a file} 
   * @param providerID
   * @return
   * @throws IOException
   */
  public static ProviderRecord getProviderRecordFromFile(String providerID) throws IOException {
      // Read all the provider records from the file
      List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/Provider_Record"));

      // Find the provider record with the given number
      for (String line : lines) {
          if (line.startsWith(providerID + ",")) {
              // Parse the provider record data from the line
              String[] parts = line.split(",");
              String name = parts[1];
              String number = parts[0];
              String address = parts[2];
              String city = parts[3];
              String state = parts[4];
              String zipcode = parts[5];

              // Create a new provider record object with the parsed datae
              ProviderRecord providerRecord = new ProviderRecord(name, number, address, city, state, zipcode);
              return providerRecord;
          }
      }

      // If no provider record with the given number was found, return null
      return null;
  }
  /**
   * {@summary A helper method that gets a member record from a file} 
   * @param memberID
   * @return
   * @throws IOException
   */
  private static MemberRecord getMemberRecordFromFile(String memberID) throws IOException {
      // Read all the member records from the file
      List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/Member_Record"));

      // Find the member record with the given number
      for (String line : lines) {
          if (line.startsWith(memberID + ",")) {
              // Parse the member record data from the line
              String[] parts = line.split(",");
              String name = parts[1];
              String number = parts[0];
              String address = parts[2];
              String city = parts[3];
              String state = parts[4];
              String zipcode = parts[5];

              // Create a new member record object with the parsed data
              MemberRecord memberRecord = new MemberRecord(name, number, address, city, state, zipcode);
              return memberRecord;
          }
      }

      // If no member record with the given number was found, return null
      return null;
  }

  /**
   * {@summary given a provider record creates a provider report for the given provider}
   * @param currentProvider
   * @return
   */
  ProviderReport requestSingleProviderReport(ProviderRecord currentProvider) {
      ArrayList<Service> providerServices = serviceList.usersServices(Integer.parseInt(currentProvider.getNumber()));
      int totalFee = 0;
      int totalConsults = 0;
      ArrayList<Integer> dateOfService = new ArrayList<Integer>();
      ArrayList<Integer> dateReceived = new ArrayList<Integer>();
      ArrayList<String> memberNames = new ArrayList<String>();
      ArrayList<Integer> memberNumbers = new ArrayList<Integer>();
      ArrayList<Integer> serviceCodes = new ArrayList<Integer>();
      ArrayList<Integer> serviceFees = new ArrayList<Integer>();
      for(int i = 0; i < providerServices.size(); i++) {
          Service currentService = providerServices.get(i);
          MemberRecord serviceMember = memberRecordHash.memberAt(currentService.getMemberNum());
          int fee = providerDirectory.feeLookup(currentService.getServiceCode());
          memberNames.add(i,serviceMember.getName());
          memberNumbers.add(i,currentService.getMemberNum());
          dateOfService.add(i, currentService.getDateProvided());
          dateReceived.add(i, currentService.getCurrentDate());
          serviceCodes.add(i,currentService.getServiceCode());
          serviceFees.add(i,fee);
          totalFee += fee;
      }
      totalConsults = providerServices.size();
      ProviderReport providerReport = new ProviderReport(currentProvider.getName(),currentProvider.getNumber(),currentProvider.getAddress(),currentProvider.getCity(),currentProvider.getState(),currentProvider.getZipCode(),totalConsults,totalFee,dateOfService,dateReceived,memberNames,memberNumbers,serviceCodes,serviceFees);
      return providerReport;
  }

  /**
   * {@summary Creates a provider report for every provider}
   */
  ProviderReport requestProviderReport(String providerId) {
    // create a hash map... the key is the name, the value is an object of all the
    // stuff
    try {
        // Current provider in the for loop that loops through the providerrecordhash
        ProviderRecord currentProvider = ProviderRecordHash.providerAt(Integer.parseInt(providerId));
        ProviderReport providerReport = requestSingleProviderReport(currentProvider);
        return providerReport;
    }
    catch(Exception e) {
        System.out.println("Error in member report");
    }
    return null;
}

  /**
   * {@summary given a provider record creates a provider report for the given provider}
   * @param currentProvider
   * @return
   */
  MemberReport requestSingleMemberReport(MemberRecord currentMember) {
      ArrayList<Service> memberServices = serviceList.usersServices(Integer.parseInt(currentMember.getNumber()));
      ArrayList<Integer> dateOfService = new ArrayList<Integer>();
      ArrayList<String> providerNames = new ArrayList<String>();
      ArrayList<String> serviceNames = new ArrayList<String>();

      for(int i = 0; i < memberServices.size(); i++) {
          Service currentService = memberServices.get(i);
          ProviderRecord serviceProvider = ProviderRecordHash.providerAt(currentService.getProviderNum());
          dateOfService.add(currentService.getDateProvided());
          if(!(providerNames.contains(serviceProvider.getName()))) {
              providerNames.add(serviceProvider.getName());
          }
          serviceNames.add(providerDirectory.serviceLookup(currentService.getServiceCode()));
      }
      MemberReport memberReport = new MemberReport(currentMember.getName(),currentMember.getNumber(),currentMember.getAddress(),currentMember.getCity(),currentMember.getState(),currentMember.getZipCode(),dateOfService,providerNames,serviceNames);
      return memberReport;
  }

  /**
   * {@summary creates a member report for every member that participates in a service that week}
   */
  MemberReport requestMemberReport(String memberId) {
      // create a hash map... the key is the name, the value is an object of all the
      // stuff
      try {
          // Current Member in the for loop that loops through the Memberrecordhash
          MemberRecord currentMember = memberRecordHash.memberAt(Integer.parseInt(memberId));
          MemberReport memberReport = requestSingleMemberReport(currentMember);
          return memberReport;
      }
      catch(Exception e) {
          System.out.println("Error in member report");
      }
      return null;
  }
  /**
   * {@summary Creates a summary report with every provider, their number of constuls and fee and also total number of providers consultations and fees}
   * @return
   */
  public SummaryReport requestSummaryReport() {
      // for every provider - # num of consults, total fee then total num of
      // providers, total num of consultations, and total fee
      Service currentService;
      ArrayList<String> providerNames = new ArrayList<String>();
      ArrayList<Integer> providerFees = new ArrayList<Integer>();
      ArrayList<Integer> providerConsults = new ArrayList<Integer>();
      ProviderRecord providerRecord;
      int totalFee = 0;

      try {
          for (int i = 0; i < serviceList.getSize(); i++) {
              currentService = serviceList.serviceAt(i);
              providerRecord = getProviderRecordFromFile(Integer.toString(currentService.getProviderNum()));
              int serviceFee = providerDirectory.feeLookup(currentService.getServiceCode());
              totalFee += serviceFee;
              if (providerNames.contains(providerRecord.getName())) {
                  int currentIndex = providerNames.indexOf(providerRecord.getName());
                  providerFees.set(currentIndex,providerFees.get(currentIndex) + serviceFee);
                  providerConsults.set(currentIndex, providerConsults.get(currentIndex) + 1);
              } 
              else {
                  providerNames.add(providerRecord.getName());
                  providerFees.add(serviceFee);
                  providerConsults.add(1);
              }
          }
          SummaryReport summaryReport = new SummaryReport(providerNames, providerConsults, providerFees,
                  providerNames.size(), serviceList.getSize(), totalFee);
          return summaryReport;
      } 
      catch (IOException e) {
          System.out.println("Error");
      }
      return null;
  }

  public static void main(String[] args) throws IOException {
    WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
    weeklyAccountingProcedure.requestSummaryReport();
  }
}
