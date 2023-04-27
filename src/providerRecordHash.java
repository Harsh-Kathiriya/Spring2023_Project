//import java.io.File;  // Import the File class
//import java.util.Scanner;
//import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
//import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;


public class providerRecordHash {

    private static final String PROVIDER_FILE_NAME = System.getProperty("user.dir") + "/src/Provider_Record";
    public static String providerID = "123456789";
    List<Integer> sortedMap;
    Hashtable<Integer, ProviderRecord> info;

    providerRecordHash() throws IOException{
        info = new Hashtable<>();
        List<String> lines = Files.readAllLines(Paths.get(PROVIDER_FILE_NAME));
        for(String line : lines){
            if(line.startsWith(providerID+",")){
                String[] parts = line.split(",");
                String name = parts[0];
                String id = parts[1];
                String adress = parts[3];
                String city = parts[4];
                String state = parts[5];
                String zip = parts[6];
                
                ProviderRecord provider = new ProviderRecord(name, id, adress, city, state, zip);
                int num = Integer.parseInt(id);
                info.put(num, provider);
            }
        }

        /* 
        try{
            Scanner recordReader = new Scanner(recordFile);
            while(recordReader.hasNextLine()) {
                String data = recordReader.nextLine();
                String[] parts = data.split(",");
                String name = parts[0];
                String id = parts[1];
                String adress = parts[3];
                String city = parts[4];
                String state = parts[5];
                String zip = parts[6];

                ProviderRecord provider = new ProviderRecord(name, id, adress, city, state, zip);
                int num = Integer.parseInt(id);
                info.put(num, provider);

            }
            recordReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
            e.printStackTrace();
        }
        */

        sortedMap = new ArrayList<>(info.keySet());
        Collections.sort(sortedMap);


    }

    
    public ProviderRecord providerAt(Integer ident){
        ProviderRecord person = info.get(ident);
        return person;
    }
    
    public Integer getSize(){
        return info.size();
    }

}
