package classes;

/**
 * @author: Harsh Kathiriya
 * {@summary: This class controlls all the logic of operatorGui. All the feature like adding,
 * removing and editing members and providers are written here.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class OperatorController {
    private static final String MEMBER_FILE_NAME = System.getProperty("user.dir") + "/src/Member_Record";
    private static final String PROVIDER_FILE_NAME = System.getProperty("user.dir") + "/src/Provider_Record";

    /**
     * @summary: Adds a new member record to the file.
     *
     * @param member The MemberRecord object to be added to the file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void addMember(MemberRecord member) throws IOException {
        String memberNumber = generateUniqueNumber(MEMBER_FILE_NAME);
        member.setNumber(memberNumber);
        writeRecordToFile(MEMBER_FILE_NAME, member);
    }

     /**
     * @summary: Removes the member record with the given member number from the file.
     *
     * @param memberNumber The member number of the member record to be removed.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void removeMember(String memberNumber) throws IOException {
        removeRecordFromFile(MEMBER_FILE_NAME, memberNumber);
    }

    /**
     * @summary: Edits the member record with the given member number in the file.
     *
     * @param memberNumber The member number of the member record to be edited.
     * @param name The new name of the member.
     * @param address The new address of the member.
     * @param city The new city of the member.
     * @param state The new state of the member.
     * @param zipcode The new ZIP code of the member.
     * @return true if the record was edited successfully, false otherwise.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static boolean editMember(String memberNumber, String name, String address, String city, String state, String zipcode)
            throws IOException {
        MemberRecord member = getMemberRecordFromFile(memberNumber);
        if(member==null){
            return false;
        }
        member.setName(name);
        member.setAddress(address);
        member.setCity(city);
        member.setState(state);
        member.setZipCode(zipcode);

        removeRecordFromFile(MEMBER_FILE_NAME, memberNumber);
        writeRecordToFile(MEMBER_FILE_NAME, member);
        return true;
    }

     /**
     * @summary: Adds a new provider record to the file.
     *
     * @param provider The ProviderRecord object to be added to the file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void addProvider(ProviderRecord provider) throws IOException {
        String providerNumber = generateUniqueNumber(PROVIDER_FILE_NAME);
        provider.setNumber(providerNumber);
        writeRecordToFile(PROVIDER_FILE_NAME, provider);
    }

    /**
     * Removes the provider record with the given provider number from the file.
     *
     * @param providerNumber The provider number of the provider record to be removed.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void removeProvider(String providerNumber) throws IOException {
        removeRecordFromFile(PROVIDER_FILE_NAME, providerNumber);
    }


    /**
     * @summary: Edits the provider record with the given provider number in the file.
     *
     * @param providerNumber The provider number of the provider record to be edited.
     * @param name The new name of the provider.
     * @param address The new address of the provider.
     * @param city The new city of the provider.
     * @param state The new state of the provider.
     * @param zipcode The new ZIP code of the provider.
     * @return true if the record was edited successfully, false otherwise.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static boolean editProvider(String providerNumber, String name, String address, String city, String state, String zipcode)
            throws IOException {
        ProviderRecord provider = getProviderRecordFromFile(providerNumber);
        if(provider == null){
            return false;
        }
        provider.setName(name);
        provider.setAddress(address);
        provider.setCity(city);
        provider.setState(state);
        provider.setZipCode(zipcode);

        removeRecordFromFile(PROVIDER_FILE_NAME, providerNumber);
        writeRecordToFile(PROVIDER_FILE_NAME, provider);
        return true;
    }

    /**
    * @summary: Generates a unique 9-digit number for a new member or provider.
    * @param fileName the name of the file to check for existing numbers.
    * @return a unique 9-digit number.
    */
    public static String generateUniqueNumber(String fileName) {
        String number;
            do {
                number = String.format("%09d", new Random().nextInt(1000000000));
            } while (recordNumberExistsInFile(fileName, number));
        return number;
    }

    /**
    * @summary: Writes a record to the given file.
    * @param fileName the name of the file to write the record to.
    * @param record the record to be written.
    * @throws IOException if there is an error writing to the file.
    */
    private static void writeRecordToFile(String fileName, Record record) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(record.getNumber() + "," +
                          record.getName() + "," +
                          record.getAddress() + "," +
                          record.getCity() + "," +
                          record.getState() + "," +
                          record.getZipCode() + "\n");


    bufferedWriter.close();
}

    /**
    * @summary: Removes a record with the given number from the given file.
    * @param fileName the name of the file to remove the record from.
    * @param recordNumber the unique id of the record to be removed.
    * @throws IOException if there is an error reading or writing to the file.
    */
    private static void removeRecordFromFile(String fileName, String recordNumber) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        lines.removeIf(line -> line.startsWith(recordNumber + ","));
        Files.write(Paths.get(fileName), lines);
    }

    /**
    * @summary: Checks if a given record number exists in a specified file.
    * @param fileName the name of the file to search in
    * @param recordNumber the record number to search for
    * @return true if the record number exists in the file, false otherwise
    */
    public static boolean recordNumberExistsInFile(String fileName, String recordNumber) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        for (String line : lines) {
            if (line.startsWith(recordNumber + ",")) {
                return true;
            }
        }
        return false;
    }

    /**
    @summary: Returns the member record with the given number from the member file.
    @param memberNumber the member number to search for
    @return the MemberRecord object if found, null otherwise
    @throws IOException if there was an error reading the file
    */
    public static MemberRecord getMemberRecordFromFile(String memberNumber) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(MEMBER_FILE_NAME));

        for (String line : lines) {
            if (line.startsWith(memberNumber + ",")) {
                String[] parts = line.split(",");
                String number = parts[0];
                String name = parts[1];
                String address = parts[2];
                String city = parts[3];
                String state = parts[4];
                String zipcode = parts[5];

                MemberRecord member = new MemberRecord(name, number, address, city, state, zipcode);
                return member;
            }
        }

        return null;
    }

    /**
    @summary:Returns the provider record with the given number from the provider file.
    @param providerNumber the provider number to search for
    @return the provider record object if found, null otherwise
    @throws IOException if there was an error reading the file
    */
    private static ProviderRecord getProviderRecordFromFile(String providerNumber) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(PROVIDER_FILE_NAME));
        for (String line : lines) {
            if (line.startsWith(providerNumber + ",")) {
                String[] parts = line.split(",");
                String number = parts[0];
                String name = parts[1];
                String address = parts[2];
                String city = parts[3];
                String state = parts[4];
                String zipcode = parts[5];
                ProviderRecord provider = new ProviderRecord(name, number, address, city, state, zipcode);
                return provider;
            }
        }
        return null;
    }

}