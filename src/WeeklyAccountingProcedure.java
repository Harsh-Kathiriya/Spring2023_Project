import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WeeklyAccountingProcedure {
    public static ProviderRecord getProviderRecordFromFile(String providerID) throws IOException {
        // Read all the provider records from the file
        List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/Provider_Record"));

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
                ProviderRecord providerRecord = new ProviderRecord(name, number, address, city, state, zipcode);
                return providerRecord;
            }
        }

        // If no provider record with the given number was found, return null
        return null;
    }

    private static MemberRecord getMemberRecordFromFile(String memberID) throws IOException {
        // Read all the member records from the file
        List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/Member_Record"));

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
                MemberRecord memberRecord = new MemberRecord(name, number, address, city, state, zipcode);
                return memberRecord;
            }
        }

        // If no member record with the given number was found, return null
        return null;
    }

    void requestProviderReport() {
        // create a hash map... the key is the name, the value is an object of all the
        // stuff
        try {
            providerRecordHash ProviderRecordHash = new providerRecordHash();
            // Current provider in the for loop that loops through the providerrecordhash
            ProviderRecord currentProvider;
            // List of all services in the week
            ServiceList serviceList = new ServiceList();
            // Provider Directory
            ProviderDirectory providerDirectory = new ProviderDirectory();
            // The member that received a specific service
            MemberRecord memberRecord;
            // the provider record hash again for some reason lmao
            MemberRecordHash memberRecordHash = new MemberRecordHash();
            // All the services a certain provider has had
            ArrayList<Service> providerServices;
            // The current service in the for loop
            Service currentService;
            // The current fee in the for loop
            int serviceFee;
            int totalFee = 0;
            for (int i = 0; i < ProviderRecordHash.getSize(); i++) {
                currentProvider = ProviderRecordHash.providerAt(i);
                System.out.println(currentProvider.getName() + " " + currentProvider.getNumber() + " "
                        + currentProvider.getAddress() + " " + currentProvider.getCity() + " " + currentProvider.getState()
                        + " " + currentProvider.getZipCode());
                providerServices = serviceList.usersServices(Integer.valueOf(currentProvider.getNumber()));
                for (int j = 0; j < providerServices.size(); j++) {
                    currentService = providerServices.get(j);
                    memberRecord = getMemberRecordFromFile(Integer.toString(currentService.getMemberNum()));
                    serviceFee = providerDirectory.feeLookup(currentService.getServiceCode());
                    totalFee += serviceFee;
                    System.out.println(currentService.getDateProvided() + " " + currentService.getCurrentDate() + " "
                            + memberRecord.getName() + currentService.getMemberNum() + " " + currentService.getServiceCode()
                            + " " + Integer.toString(serviceFee));

                }
                System.out.println(providerServices.size());
                System.out.println(totalFee + " \n \n \n");
            }
        }
        catch(Exception e) {
            
        }
    }

    void requestMemberReport() {
        try {
            MemberRecordHash memberRecordHash = new MemberRecordHash();
            MemberRecord currentMember;
            ServiceList serviceList = new ServiceList();
            ProviderDirectory providerDirectory = new ProviderDirectory();
            ProviderRecord providerRecord;
            providerRecordHash providerRecordHash = new providerRecordHash();
            ArrayList<Service> memberServices;
            /*
            * ArrayList<Integer> dateOfServices;
            * ArrayList<String> providerNames;
            * ArrayList<String> serviceNames;
            */
            Service currentService;
            String serviceName;
            for (int i = 0; i < memberRecordHash.getSize(); i++) {
                currentMember = memberRecordHash.memberAt(i);
                System.out.println(currentMember.getName() + " " + currentMember.getNumber() + " "
                        + currentMember.getAddress() + " " + currentMember.getCity() + " " + currentMember.getState() + " "
                        + currentMember.getZipCode());
                memberServices = serviceList.usersServices(Integer.valueOf(currentMember.getNumber()));
                for (int j = 0; j < memberServices.size(); j++) {
                    currentService = memberServices.get(j);
                    providerRecord = getProviderRecordFromFile(Integer.toString(currentService.getProviderNum()));
                    serviceName = providerDirectory.serviceLookup(currentService.getServiceCode());
                    System.out
                            .println(currentService.getDateProvided() + " " + providerRecord.getName() + " " + serviceName);
                }
            }
        }
        catch(Exception e) {

        }
    }

    public SummaryReport requestSummaryReport() {
        // for every provider - # num of consults, total fee then total num of
        // providers, total num of consultations, and total fee
        ServiceList serviceList = new ServiceList();
        Service currentService;
        ArrayList<String> providerNames = new ArrayList<String>();
        ArrayList<Integer> providerFees = new ArrayList<Integer>();
        ArrayList<Integer> providerConsults = new ArrayList<Integer>();
        ProviderRecord providerRecord;
        ProviderDirectory providerDirectory = new ProviderDirectory();
        int totalFee = 0;

        try {
            for (int i = 0; i < serviceList.getSize(); i++) {
                currentService = serviceList.serviceAt(i);
                providerRecord = getProviderRecordFromFile(Integer.toString(currentService.getProviderNum()));
                int serviceFee = providerDirectory.feeLookup(currentService.getServiceCode());
                totalFee += serviceFee;
                if (providerNames.contains(providerRecord.getName())) {
                    int currentIndex = providerNames.indexOf(providerRecord.getName());
                    providerFees.set(currentIndex,
                            providerFees.get(providerNames.indexOf(providerRecord.getName()) + serviceFee));
                    providerConsults.set(currentIndex, providerConsults.get(currentIndex) + 1);
                } else {
                    providerNames.add(providerRecord.getName());
                    providerFees.add(serviceFee);
                    providerConsults.add(1);
                }
            }
            SummaryReport summaryReport = new SummaryReport(providerNames, providerConsults, providerFees,
                    providerNames.size(), serviceList.getSize(), totalFee);
            return summaryReport;
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }

    void requestEFTReport() {

    }

}
