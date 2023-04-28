package classes;
import java.util.Scanner; //Allows use of user input

/**
 * @author Austin Smith
 */
public class Verification{

    //Variables
    int userNum;
    static Credentials credentials = new Credentials();
    Scanner userReader = new Scanner(System.in);

    /* 
    String displayInput(){
        return null;
    
    }
    */
    
    /* Will return value based on role of user ie. manager, provider,
     or operator. -1 indicates user is not valid.*/

    static int userVerification(int userNum){
        if(credentials.searchManagerList(userNum) == true){
            return 0; //is manager
        }
        if(credentials.searchProviderList(userNum) == true){
            return 1; //is provider
        }
        if(credentials.searchOperatorList(userNum) == true){
            return 2; //is opperator
        }
        if(credentials.searchMemberList(userNum) == true){
            System.out.println("null");
            return 3; //is member
        }
        else return -1; //unauthorized user

        
    }



}