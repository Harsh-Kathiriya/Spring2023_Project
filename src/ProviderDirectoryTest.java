import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ProviderDirectoryTest{

    ProviderDirectory testDirect = new ProviderDirectory();

    @Before
    public void SetUp() throws Exception{

    }

    @Test
    public void test(){
        Integer testInt = testDirect.feeLookup(100001);
        
    }
}