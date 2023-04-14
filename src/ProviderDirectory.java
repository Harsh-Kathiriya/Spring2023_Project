import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProviderDirectory{

    ArrayList<String> serviceNames = new ArrayList<String>();
    ArrayList<Integer> serviceCodes = new ArrayList<Integer>();
    ArrayList<Integer> serviceFees = new ArrayList<Integer>();
    
    public void requestProviderDirectory(){
        try{
            //change file name to name of the file with the correct directory info
            File directoryInfo = new File("C:\\Users\\Aaron Buff\\Visual Studio Programs\\testText.txt");
            Scanner readIn = new Scanner(directoryInfo);

            String tempString;
            Integer tempInt;

            //reads file and stores lines into two arrays
            while(readIn.hasNext()){
                tempString = readIn.next();
                tempInt = Integer.parseInt(tempString);
                serviceCodes.add(tempInt);
                tempString = readIn.next();
                serviceNames.add(tempString);
                tempString = readIn.next();
                tempInt = Integer.parseInt(tempString);
                serviceFees.add(tempInt);
            }
            readIn.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
    }

    public Int feeLookup(int serviceNum){
        int marker = 0;
        for(int i = 0; i < serviceCodes.size(); i++){
            if(serviceCodes.get(i) == serviceNum){
                marker = i;
            }
        }
        return serviceFees.get(marker);
    }

    public String serviceLookup(int serviceNum){
        int marker = 0;
        for(int i = 0; i < serviceCodes.size(); i++){
            if(serviceCodes.get(i) == serviceNum){
                marker = i;
            }
        }
        return serviceNames.get(marker);
    }
}