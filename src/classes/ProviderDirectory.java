package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProviderDirectory{

    public ArrayList<String> serviceNames = new ArrayList<String>();
    public ArrayList<Integer> serviceCodes = new ArrayList<Integer>();
    public ArrayList<Integer> serviceFees = new ArrayList<Integer>();
    
    public void requestProviderDirectory(){
        try{
            //change file name to name of the file with the correct directory info
            File directoryInfo = new File("./data/provider_directory");
            Scanner readIn = new Scanner(directoryInfo);

            String tempString;
            Integer tempInt;

            //reads file and stores lines into two arrays
            while(readIn.hasNextLine()){
                tempString = readIn.nextLine();
                String[] arr = tempString.split(",");
                serviceCodes.add(Integer.parseInt(arr[0]));
                serviceNames.add(arr[1]);
                serviceFees.add(Integer.parseInt(arr[2]));
            }
            readIn.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
    }

    
    /** 
     * 
     * @param serviceNum
     * @return int
     */
    public int feeLookup(int serviceNum){
        int marker = 999;
        requestProviderDirectory();
        for(int i = 0; i < serviceCodes.size(); i++){
            if(serviceCodes.get(i) == serviceNum){
                marker = i;
            }
        }
        if(marker==999){
            return 99999;
        }
        else return serviceFees.get(marker);
    }

    
    /** 
     * @param serviceNum
     * @return String
     */
    public String serviceLookup(int serviceNum){
        int marker = 0;
        requestProviderDirectory();
        for(int i = 0; i < serviceCodes.size(); i++){
            if(serviceCodes.get(i) == serviceNum){
                marker = i;
            }
        }
        return serviceNames.get(marker);
    }
}