import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SebastianUnitTest {

    private ManagerController managerController;

    @Before
    public void setUp() throws Exception {
        managerController = new ManagerController();
    }

    @Test
    public void testGetProviderRecordFromFile() {
        try {
            ProviderRecord providerRecord = ManagerController.getProviderRecordFromFile("100000001");
            assertNotNull(providerRecord);
            assertEquals("John Smith", providerRecord.getName());
            assertEquals("100000001", providerRecord.getNumber());
            assertEquals("123 Main St", providerRecord.getAddress());
            assertEquals("Anytown", providerRecord.getCity());
            assertEquals("NY", providerRecord.getState());
            assertEquals("12345", providerRecord.getZipCode());
        } catch (IOException e) {
            fail("IOException should not have been thrown.");
        }
    }

    @Test
    public void testGetMemberRecordFromFile() {
        try {
            MemberRecord memberRecord = ManagerController.getMemberRecordFromFile("200000001");
            assertNotNull(memberRecord);
            assertEquals("Alice Johnson", memberRecord.getName());
            assertEquals("200000001", memberRecord.getNumber());
            assertEquals("456 High St", memberRecord.getAddress());
            assertEquals("Anytown", memberRecord.getCity());
            assertEquals("NY", memberRecord.getState());
            assertEquals("12345", memberRecord.getZipCode());
        } catch (IOException e) {
            fail("IOException should not have been thrown.");
        }
    }

    @Test
    public void testRequestSingleProviderReport() {
        ProviderRecord providerRecord = new ProviderRecord("John Smith", "100000001", "123 Main St", "Anytown", "NY", "12345");
        ProviderReport providerReport = managerController.requestSingleProviderReport(providerRecord);
        assertNotNull(providerReport);
        assertEquals(providerRecord.getName(), providerReport.getProviderName());
        assertEquals(providerRecord.getNumber(), providerReport.getProviderNumber());
    }

    @Test
    public void testRequestProviderReport() {
        ProviderReport providerReport = managerController.requestProviderReport("100000001");
        assertNotNull(providerReport);
        assertEquals("John Smith", providerReport.getProviderName());
        assertEquals("100000001", providerReport.getProviderNumber());
    }

    @Test
    public void testRequestSingleMemberReport() {
        MemberRecord memberRecord = new MemberRecord("Alice Johnson", "200000001", "456 High St", "Anytown", "NY", "12345");
        MemberReport memberReport = managerController.requestSingleMemberReport(memberRecord);
        assertNotNull(memberReport);
        assertEquals(memberRecord.getName(), memberReport.getMemberName());
        assertEquals(memberRecord.getNumber(), memberReport.getMemberNumber());
    }

    @Test
    public void testRequestMemberReport() {
        MemberReport memberReport = managerController.requestMemberReport("200000001");
        assertNotNull(memberReport);
        assertEquals("Alice Johnson", memberReport.getMemberName());
        assertEquals("200000001", memberReport.getMemberNumber());
    }

    @Test
    public void testRequestSummaryReport() {
        SummaryReport summaryReport = managerController.requestSummaryReport();
        assertNotNull(summaryReport);
        assertTrue(summaryReport.getProviderNames().contains("John Smith"));
    }

}
