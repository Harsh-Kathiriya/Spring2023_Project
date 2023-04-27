import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CredentialsTest {

    @Test 
    public void testUsernameTooShort() {
        try{
            Credentials creds = new Credentials();
            creds.searchManagerList(10000000);
            //fail ();
        }
        catch(IllegalArgumentException ex){
            assertEquals("Credentials number is too short. Must be 9 digits", ex.getMessage());
        }
    }

    @Test
    public void testUsernameTooLong(){
        try{
            Credentials creds = new Credentials();
            creds.searchManagerList(1000000000);
            //fail ();
        }
        catch(IllegalArgumentException ex){
            assertEquals("Credentials number is too long. Must be 9 digits", ex.getMessage());
        }
    }
    
}