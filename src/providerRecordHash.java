import java.io.File;  // Import the File class
import java.util.Scanner;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;
import java.io.*;


public class providerRecordHash {

    List<Integer> sortedMap;
    Hashtable<Integer, ProviderRecord> info;

    providerRecordHash(){
        info = new Hashtable<>();
        File recordFile = new File("C:\\Users\\emily\\OneDrive\\Desktop\\cs200 proj\\projectRepository\\spring23team1\\src\\Provider_Record.txt");

        try{
            Scanner recordReader = new Scanner(recordFile);
            while(recordReader.hasNextLine()) {
                String data = recordReader.nextLine();
                String[] parts = data.split(",");
                String name = parts[0];
                String id = parts[1];
                String adress = parts[2];
                String city = parts[3];
                String state = parts[4];
                String zip = parts[5];

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

        sortedMap = new ArrayList<>(info.keySet());
        Collections.sort(sortedMap);

    }

    

    public void getInfo(Integer ident){
        ProviderRecord person = info.get(ident);
        if (person != null) {
            System.out.println("Name: " + person.getName() + ", ID: " + person.getNumber() + ", Address: " + person.getAddress() + ", Zip Code: " + person.getZipCode() + ", State: " + person.getState() + ", Zip: " + person.getZipCode());
        } 
        else {
            System.out.println("Provider with ID " + ident + " not found.");
        }
    }

    public void getAll(){
        for (Integer key : sortedMap){
            getInfo(key);
        }
    }


    public static void main(String[] args) throws IOException {
        providerRecordHash hash = new providerRecordHash();
        hash.getAll();

    }

}
