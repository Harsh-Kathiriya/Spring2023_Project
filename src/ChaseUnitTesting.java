import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ChaseUnitTesting {
    @Test
    public void RequestProviderReportSuccess() {
        try {
            WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
            ArrayList<ProviderReport> providerReports = weeklyAccountingProcedure.requestProviderReport();
            assertTrue(providerReports != null);
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    } 
    @Test
    public void RequestMemberReportSuccess() {
        try {
            WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
            ArrayList<MemberReport> memberReports = weeklyAccountingProcedure.requestMemberReport();
            assertTrue(memberReports != null);
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    @Test
    public void reportSuccess() {
        try {
            MemberRecord Record = new MemberRecord("Default","Default","Default","Default","Default","Default");
            assertEquals("Default", Record.getName());
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
