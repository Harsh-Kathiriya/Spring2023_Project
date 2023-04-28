import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AaronUnitTest{


    ProviderDirectory testDirect = new ProviderDirectory();


    @Before
    public void SetUp() throws Exception{
        testDirect.serviceCodes.add(123456);
        testDirect.serviceNames.add("Test Service");
        testDirect.serviceFees.add(30);
    }


    @Test
    public void feeLookupSuccesstest(){
        assertTrue(testDirect.feeLookup(123456) == 30);
    }


    @Test
    public void feeLookupFailureTest(){
        assertFalse(testDirect.feeLookup(123456) == 10);
    }


    @Test
    public void serviceLookupSuccessTest(){
        assertTrue(testDirect.serviceLookup(123456) == "Test Service");
    }


    @Test
    public void serviceLookupFailureTest(){
        assertFalse(testDirect.serviceLookup(123456) == "Bad Service");
    }
}



