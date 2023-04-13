
public class Verification{


    int userNum;

    Credentials credentials;

    String displayInput(){
        return null;
    
    }
    void enterInformation(){

    }
    int userVerification(){
        if(credentials.searchManagerList(userNum) == true){
            return 0;
        }
        if(credentials.searchProviderList(userNum) == true){
            return 1;
        }
        if(credentials.searchOperatorList(userNum) == true){
            return 2;
        }
        else return -1;

        
    }



}