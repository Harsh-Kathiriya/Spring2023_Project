import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class ProviderControllerTestHarsh {
    @Test
    public void testFeeLookup() {
        // Create a provider directory and add some test services
        ProviderDirectory directory = new ProviderDirectory();
        directory.serviceCodes.add(324543);
        directory.serviceFees.add(25);
        directory.serviceNames.add("Service A");

        directory.serviceCodes.add(324549);
        directory.serviceFees.add(50);
        directory.serviceNames.add("Service B");

        // Test fee lookup for valid service codes
        assertEquals(25, directory.feeLookup(324543));

        assertEquals(50, directory.feeLookup(324549));

        assertEquals(99999, directory.feeLookup(111111));
        
    }
}