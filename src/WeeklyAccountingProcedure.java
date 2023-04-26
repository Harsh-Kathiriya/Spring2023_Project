
public class WeeklyAccountingProcedure {
    void requestProviderReport(){
        
    }

    void requestMemberReport(){

    }

    void requestSummaryReport(){
        ServiceList serviceList = new ServiceList();
        for(int i = 0; i < serviceList.getSize(); i++) {
            serviceList.serviceAt(i);
        }
    }

    void requestETFReport(){

    }


}
