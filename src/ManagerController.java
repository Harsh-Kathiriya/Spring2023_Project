public class ManagerController {

  public static void /* not sure if should be void or somwthing else? */ RequestProviderReport(){
    ProviderReport providerReport = new ProviderReport(/* ? */);
    System.out.println(providerReport); /* Temporary till we have the menus to display to */
  }

  public static void /* not sure if should be void or somwthing else? */ RequestSummaryReport(){
    SummaryReport summaryReport = new SummaryReport(/* ? */);
    System.out.println(summaryReport); /* Temporary till we have the menus to display to */
  }
  // Don't think i can do much more until we have actual files for me to pull from or menus for me to display to //

  public static void RequestMemberReport(){
    MemberReport memberReport = new MemberReport();
    System.out.println(memberReport); 
  }
}
