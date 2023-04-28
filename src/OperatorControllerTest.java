import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OperatorControllerTest {

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

    @Test
    public void testGetMemberRecordFromFile() throws IOException {
        MemberRecord member = OperatorController.getMemberRecordFromFile("258369258");
        assertNotNull(member);
        assertEquals("Joshua Garcia", member.getName());
        assertEquals("258369258", member.getNumber());
        assertEquals("456 Pine St", member.getAddress());
        assertEquals("Anytown", member.getCity());
        assertEquals("CA", member.getState());
        assertEquals("90002", member.getZipCode());

        //Id cannot have 0 at the beginning
        MemberRecord member2 = OperatorController.getMemberRecordFromFile("011111111");
        assertNull(member2);
    }

}