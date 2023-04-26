import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class MemberRecordHash {

    class member{
        String number;
        String memberName;
        String street;
        String city;
        String state;
        String zipCode;
    
        member(String number, String memberName, String street, String cityString
        , String state, String zipCode){
            this.number = number;
            this.memberName = memberName;
            this.street = street;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
        }
    }
}
