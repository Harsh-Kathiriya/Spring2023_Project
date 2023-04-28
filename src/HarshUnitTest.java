import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HarshUnitTest {

    @Test
    public void testGenerateUniqueNumber() throws IOException {
        String fileName = "records.txt";
        List<String> existingNumbers = new ArrayList<>();
        existingNumbers.add("789456123,Emma Davis,369 Maple St,Sometown,NY,10004");
        existingNumbers.add("654321987,Matthew Brown,654 Cedar Ln,Anytown,NC,28005");
        existingNumbers.add("789456123,James Lee,951 Cedar St,Anyvillage,FL,33007");
        File file = new File(fileName);
        Path path = file.toPath();
        Files.write(path, existingNumbers);

        String uniqueNumber = OperatorController.generateUniqueNumber(fileName);
        assertNotNull(uniqueNumber);
        assertEquals(9, uniqueNumber.length());
        assertFalse(existingNumbers.contains(uniqueNumber));

        assertTrue(OperatorController.recordNumberExistsInFile(fileName, "789456123"));
        assertFalse(OperatorController.recordNumberExistsInFile(fileName, "100000000"));
        assertFalse(OperatorController.recordNumberExistsInFile(fileName, uniqueNumber));

        Files.delete(path);
    }

    // @Test
    // public void testGetMemberRecordFromFile() throws IOException {
    //     MemberRecord member = OperatorController.getMemberRecordFromFile("258369258");
    //     assertNotNull(member);
    //     assertEquals("Joshua Garcia", member.getName());
    //     assertEquals("258369258", member.getNumber());
    //     assertEquals("456 Pine St", member.getAddress());
    //     assertEquals("Anytown", member.getCity());
    //     assertEquals("CA", member.getState());
    //     assertEquals("90002", member.getZipCode());

    //     //Id cannot have 0 at the beginning
    //     MemberRecord member2 = OperatorController.getMemberRecordFromFile("011111111");
    //     assertNull(member2);
    // }

    @Test
    public void testRecordNumberExistsInFile() throws IOException {
        String FILE_NAME = System.getProperty("user.dir") + "/test_file";
        String content = "753951852,Nathan Lee,246 Cherry Ln,Othercity,OH,44003\n789456123,Jonathan Lee,753 Maple St,Someplace,WA,98005";
        Files.write(Paths.get(FILE_NAME), content.getBytes());

        // Test if record number exists in the file
        assertTrue(OperatorController.recordNumberExistsInFile(FILE_NAME, "753951852"));
        assertTrue(OperatorController.recordNumberExistsInFile(FILE_NAME, "789456123"));
        assertFalse(OperatorController.recordNumberExistsInFile(FILE_NAME, "121212121"));

        // Delete the temporary test file
        Files.delete(Paths.get(FILE_NAME));
    }
    @Test
    public void testFeeLookup() {
        // Create a provider directory and add some test services
        ProviderDirectory directory = new ProviderDirectory();
        directory.serviceCodes.add(324543);
        directory.serviceFees.add(25);
        directory.serviceNames.add("Service A");

        directory.serviceCodes.add(324549);
        directory.serviceFees.add(50);
        directory.serviceNames.add("Service B");

        // Test fee lookup for valid service codes
        assertEquals(25, directory.feeLookup(324543));

        assertEquals(50, directory.feeLookup(324549));

        assertEquals(99999, directory.feeLookup(111111));
        
    }
}