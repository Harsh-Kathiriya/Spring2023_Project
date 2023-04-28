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
    public void SuccessTestRequestSingleProviderReport() {
        ProviderRecord providerRecord = new ProviderRecord("John Smith", "100000001", "123 Main St", "Anytown", "NY", "12345");
        ProviderReport providerReport = managerController.requestSingleProviderReport(providerRecord);
        assertNotNull(providerReport);
        assertEquals(providerRecord.getName(), providerReport.getProviderName());
        assertEquals(providerRecord.getNumber(), providerReport.getProviderNumber());
    }

    @Test
    public void FailureTestRequestSingleProviderReport() {
        ProviderRecord providerRecord = new ProviderRecord("John Smith", "100000001989989", "123 Main St", "Anytown", "NY", "12345");
        ProviderReport providerReport = managerController.requestSingleProviderReport(providerRecord);
        assertNotNull(providerReport);
        assertEquals(providerRecord.getName(), providerReport.getProviderName());
        assertEquals(providerRecord.getNumber(), providerReport.getProviderNumber());
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
        MemberRecord memberRecord = new MemberRecord("Alice Johnson", "20000000198987", "456 High St", "Anytown", "NY", "12345");
        MemberReport memberReport = managerController.requestSingleMemberReport(memberRecord);
        assertNotNull(memberReport);
        assertEquals(memberRecord.getName(), memberReport.getMemberName());
        assertEquals(memberRecord.getNumber(), memberReport.getMemberNumber());
    }

}
