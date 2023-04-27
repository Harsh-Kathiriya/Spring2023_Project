import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class OperatorController {
   private static final String MEMBER_FILE_NAME = System.getProperty("user.dir") + "/src/Member_Record";
    private static final String PROVIDER_FILE_NAME = System.getProperty("user.dir") + "/src/Provider_Record";

    // Adds a new member record to the file
    public static void addMember(MemberRecord member) throws IOException {
        // Write the member record to the file
        writeRecordToFile(MEMBER_FILE_NAME, member);
    }

    // Removes the member record with the given number from the file
    public static void removeMember(String memberNumber) throws IOException {
        // Remove the member record with the given number from the file
        removeRecordFromFile(MEMBER_FILE_NAME, memberNumber);
    }

    // Edits the member record with the given number in the file
    public static void editMember(String memberNumber, String name, String address, String city, String state, String zipcode)
            throws IOException {
        // Get the member record with the given number from the file
        MemberRecord member = getMemberRecordFromFile(memberNumber);

        // Update the member record with the new data
        member.setName(name);
        member.setAddress(address);
        member.setCity(city);
        member.setState(state);
        member.setZipCode(zipcode);

        // Write the updated member record to the file
        writeRecordToFile(MEMBER_FILE_NAME, member);
    }

    // Adds a new provider record to the file
    public static void addProvider(ProviderRecord provider) throws IOException {
        // Generate a unique 9-digit number for the provider
        String providerNumber = generateUniqueNumber(PROVIDER_FILE_NAME);

        // Set the provider's number to the generated number
        provider.setNumber(providerNumber);

        // Write the provider record to the file
        writeRecordToFile(PROVIDER_FILE_NAME, provider);
    }

    // Removes the provider record with the given number from the file
    public static void removeProvider(String providerNumber) throws IOException {
        // Remove the provider record with the given number from the file
        removeRecordFromFile(PROVIDER_FILE_NAME, providerNumber);
    }

    // Edits the provider record with the given number in the file
    public static void editProvider(String providerNumber, String name, String address, String city, String state, String zipcode)
            throws IOException {
        // Get the provider record with the given number from the file
        ProviderRecord provider = getProviderRecordFromFile(providerNumber);

        // Update the provider record with the new data
        provider.setName(name);
        provider.setAddress(address);
        provider.setCity(city);
        provider.setState(state);
        provider.setZipCode(zipcode);

        // Write the updated provider record to the file
        writeRecordToFile(PROVIDER_FILE_NAME, provider);
    }

    // Generates a unique 9-digit number for a new member or provider
    static String generateUniqueNumber(String fileName) {
        // Generate a random 9-digit number
        String number;
            do {
                number = String.format("%09d", new Random().nextInt(1000000000));
            } while (recordNumberExistsInFile(fileName, number));
        return number;
    }

    // Writes a record to the given file
    private static void writeRecordToFile(String fileName, Record record) throws IOException {
        // Open the file for appending
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(record.getNumber() + "," +
                          record.getName() + "," +
                          record.getAddress() + "," +
                          record.getCity() + "," +
                          record.getState() + "," +
                          record.getZipCode() + "\n");

    // Close the file
    bufferedWriter.close();
}

// Removes a record with the given number from the given file
private static void removeRecordFromFile(String fileName, String recordNumber) throws IOException {
    // Read all the records from the file
    List<String> lines = Files.readAllLines(Paths.get(fileName));

    // Remove the record with the given number from the list
    lines.removeIf(line -> line.startsWith(recordNumber + ","));

    // Write the updated list of records back to the file
    Files.write(Paths.get(fileName), lines);
}

public static boolean recordNumberExistsInFile(String fileName, String recordNumber) {
    // Read all the records from the file
    List<String> lines;
    try {
        lines = Files.readAllLines(Paths.get(fileName));
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }

    // Check if any record in the file has the given number
    for (String line : lines) {
        if (line.startsWith(recordNumber + ",")) {
            return true;
        }
    }

    return false;
}

// Returns the member record with the given number from the file
private static MemberRecord getMemberRecordFromFile(String memberNumber) throws IOException {
    // Read all the member records from the file
    List<String> lines = Files.readAllLines(Paths.get(MEMBER_FILE_NAME));

    // Find the member record with the given number
    for (String line : lines) {
        if (line.startsWith(memberNumber + ",")) {
            // Parse the member record data from the line
            String[] parts = line.split(",");
            String name = parts[0];
            String number = parts[1];
            String address = parts[2];
            String city = parts[3];
            String state = parts[4];
            String zipcode = parts[5];

            // Create a new member record object with the parsed data
            MemberRecord member = new MemberRecord(name, number, address, city, state, zipcode);
            return member;
        }
    }

    // If no member record with the given number was found, return null
    return null;
}
private static ProviderRecord getProviderRecordFromFile(String providerNumber) throws IOException {
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
            ProviderRecord provider = new ProviderRecord(name, number, address, city, state, zipcode);
            return provider;
        }
    }

    // If no provider record with the given number was found, return null
    return null;
}

public static void addMember(String name, String address, String city, String state, String zip) {
}

}