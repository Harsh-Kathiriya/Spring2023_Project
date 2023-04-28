import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SebastianUnitTest {

    private ManagerController managerController;
    private ProviderRecord providerRecord;
    private MemberRecord memberRecord;

    @Before
    public void setUp() throws Exception {
        managerController = new ManagerController();
        providerRecord = new ProviderRecord("Ethan", "123456789", "1234 Main St.", "Anytown", "CA", "12345");
        memberRecord = new MemberRecord("Ethan", "123456789", "1234 Main St.", "Anytown", "CA", "12345");
    }

    @Test
    public void SuccessTestRequestSingleProviderReport() {
        ProviderRecord providerRecord = new ProviderRecord("John Smith", "100000001", "123 Main St", "Anytown", "NY", "12345");
        ProviderReport providerReport = managerController.requestSingleProviderReport(providerRecord);
        assertNotNull(providerReport);
        assertEquals(providerRecord.getName(), providerReport.getProviderName());
        assertEquals(providerRecord.getNumber(), providerReport.getProviderNumber());
    }

    @Test
    public void FailureTestRequestSingleProviderReport() {
        ProviderRecord providerRecord = new ProviderRecord("John Smith", "1000001989989", "123 Main St", "Anytown", "NY", "12345");
        ProviderReport providerReport = managerController.requestSingleProviderReport(providerRecord);
        assertNotNull(providerReport);
        assertEquals(providerRecord.getName(), providerReport.getProviderName());
        assertNotEquals("1000001989989", providerReport.getProviderNumber());
    }

    @Test
    public void SuccessTestRequestSingleMemberReport() {
        MemberRecord memberRecord = new MemberRecord("Alice Johnson", "200000001", "456 High St", "Anytown", "NY", "12345");
        MemberReport memberReport = managerController.requestSingleMemberReport(memberRecord);
        assertNotNull(memberReport);
        assertEquals(memberRecord.getName(), memberReport.getMemberName());
        assertEquals(memberRecord.getNumber(), memberReport.getMemberNumber());
    }

    @Test
    public void FailureTestRequestSingleMemberReport() {
        MemberRecord memberRecord = new MemberRecord("Alice Johnson", "200000198987", "456 High St", "Anytown", "NY", "12345");
        MemberReport memberReport = managerController.requestSingleMemberReport(memberRecord);
        assertNotNull(memberReport);
        assertEquals(memberRecord.getName(), memberReport.getMemberName());
        assertNotEquals("200000198987", memberReport.getMemberNumber());
    }

    @Test
    public void SuccessfulProviderRecord() {
        assertEquals("Ethan", providerRecord.getName());
        assertEquals("123456789", providerRecord.getNumber());
        assertEquals("1234 Main St.", providerRecord.getAddress());
        assertEquals("Anytown", providerRecord.getCity());
        assertEquals("CA", providerRecord.getState());
        assertEquals("12345", providerRecord.getZipCode());
    }

        @Test
    public void FailureProvideRecord() {
        providerRecord.setNumber("12345678999999999");
        assertEquals("Ethan", providerRecord.getName());
        assertNotEquals("12345678999999999", providerRecord.getNumber());
        assertEquals("1234 Main St.", providerRecord.getAddress());
        assertEquals("Anytown", providerRecord.getCity());
        assertEquals("CA", providerRecord.getState());
        assertEquals("12345", providerRecord.getZipCode());
    }

}
