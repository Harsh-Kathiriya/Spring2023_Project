import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class MemberRecordHash {

    File memberFile= new File(System.getProperty("user.dir") + "/Member_Record");
            Scanner memberReader = new Scanner(memberFile);

            while(memberReader.hasNextLine()) {
                String data = memberReader.nextLine();
                String[] temp = data.split(",");
                
            }
            memberReader.close();

}
