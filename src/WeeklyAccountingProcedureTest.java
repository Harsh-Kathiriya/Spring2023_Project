import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WeeklyAccountingProcedureTest {
    @Test
    public void RequestProviderReportSuccess() {
        try {
            WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
            weeklyAccountingProcedure.requestProviderReport();
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    } 
    public void RequestMemberReportSuccess() {
        try {

        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
