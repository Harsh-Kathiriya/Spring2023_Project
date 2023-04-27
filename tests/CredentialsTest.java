package tests;
public import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CredentialsTest {

    @Test 
    public void testUsernameTooShort() {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, () ->{
                Credentials creds = new Credentials();
                creds.searchManagerList(000000000);
            }
        );
        assertEquals("Credentials number is too short.  Must be 9 digits", exception.getMessage());     
    }
    
}
