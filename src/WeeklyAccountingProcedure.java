
public class WeeklyAccountingProcedure {
    void requestProviderReport(){
        //create a hash map... the key is the name, the value is an object of all the stuff
        
        
    }

    void requestMemberReport(){
        MemberRecordHash memberRecordHash = new MemberRecordHash();
        for(int i = 0; i < memberRecordHash.getSize(); i++){
            currentMember = memberRecordHash.memberAt(i);
            currentMember.getCity();
            serviceList.usersServices(currentMember.getID());
        }
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
