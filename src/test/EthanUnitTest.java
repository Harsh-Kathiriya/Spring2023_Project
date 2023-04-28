package test;
import org.junit.Test;

import classes.MemberRecord;
import classes.MemberReport;
import classes.ProviderRecord;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class EthanUnitTest {

    private ProviderRecord providerRecord;
    private MemberRecord memberRecord;
    @Before
    public void prepare() {
        providerRecord = new ProviderRecord("Ethan", "123456789", "1234 Main St.", "Anytown", "CA", "12345");
        memberRecord = new MemberRecord("Ethan", "123456789", "1234 Main St.", "Anytown", "CA", "12345");
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
    public void SuccessfulMemberRecord() {
        assertEquals("Ethan", memberRecord.getName());
        assertEquals("123456789", memberRecord.getNumber());
        assertEquals("1234 Main St.", memberRecord.getAddress());
        assertEquals("Anytown", memberRecord.getCity());
        assertEquals("CA", memberRecord.getState());
        assertEquals("12345", memberRecord.getZipCode());
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

    @Test
    public void SuccessMemberReport(){
        MemberReport memberReport = new MemberReport("Ethan", "123456789", "1234 Main St.", "Anytown", "CA", "12345", null, null, null);
        assertEquals("Ethan", memberReport.getMemberName());
        assertEquals("123456789", memberReport.getMemberNumber());
        assertEquals("1234 Main St.", memberReport.getMemberAddress());
        assertEquals("Anytown", memberReport.getMemberCity());
        assertEquals("CA", memberReport.getMemberState());
        assertEquals("12345", memberReport.getMemberZipCode());
    }
}
