package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

import classes.ProviderDirectory;
import classes.MemberRecord;


public class AustinUnitTesting {

    MemberRecord Record_meth;

    @Before
    public void setUp() throws Exception {
        Record_meth = new MemberRecord("Carry", "123456789","addy","bama","AL","12345");
    }
    @Test
    public void testRecord(){
       
        Record_meth.setName("Carry");
        assertEquals("Carry", Record_meth.getName());
        

    }

    @Test
    public void testRecordSt(){
        assertEquals("AL",Record_meth.getState());
    
    
    }

    ProviderDirectory providerTest = new ProviderDirectory();

    @Before
    public void setUp2() throws Exception {
        providerTest.serviceCodes.add(223987);
        providerTest.serviceNames.add("Test Case Service");
        providerTest.serviceFees.add(100);
    }

    @Test
    public void testProvider(){
        assertEquals(providerTest.feeLookup(223987), 100);
    }
}
