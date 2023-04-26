public class ManagerController {

  public static void RequestProviderReport() {
    ProviderReport providerReport = new ProviderReport();
    System.out.println(providerReport);
  }

  public static void RequestSummaryReport() {
    SummaryReport summaryReport = new SummaryReport();
    System.out.println(summaryReport);
  }

  public static void RequestMemberReport() {
    MemberReport memberReport = new MemberReport();
    System.out.println(memberReport);
  }
}
