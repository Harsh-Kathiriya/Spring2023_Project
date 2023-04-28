import java.util.*;

public class Main {
    public static void main(String args[]) {
        Terminal terminal = new Terminal();
        WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
        SummaryReport summaryReport = weeklyAccountingProcedure.requestSummaryReport();
        ArrayList<MemberReport> memberReports = weeklyAccountingProcedure.requestMemberReport();
        ArrayList<ProviderReport> providerReports = weeklyAccountingProcedure.requestProviderReport();
        System.out.println(summaryReport + "\n\n");
        for(int i = 0; i < providerReports.size(); i++) {
            System.out.println(providerReports.get(i)+ "\n");
        }
        System.out.println("\n\n");
        for(int i = 0; i < memberReports.size(); i++) {
            System.out.println(memberReports.get(i)+ "\n");
        }
    }
}
