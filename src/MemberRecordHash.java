//import java.io.File;  // Import the File class
//import java.util.Scanner;
//import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.*;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.lang.reflect.Array;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;


public class MemberRecordHash {
    private static final String MEMBER_FILE_NAME = System.getProperty("user.dir") + "/src/Provider_Record";
    public static String memberID = "258369258";

    List<Integer> sortedMap;
    Hashtable<Integer, MemberRecord> info;

    MemberRecordHash() throws IOException{
        info = new Hashtable<>();
        List<String> lines = Files.readAllLines(Paths.get(MEMBER_FILE_NAME));
        for(String line : lines){
            if(line.startsWith(memberID+",")){
                String[] parts = line.split(",");
                String name = parts[0];
                String id = parts[1];
                String adress = parts[3];
                String city = parts[4];
                String state = parts[5];
                String zip = parts[6];
                
                MemberRecord member = new MemberRecord(name, id, adress, city, state, zip);
                int num = Integer.parseInt(id);
                info.put(num, member);
            }
        }
        

        
        
        /* 
        File recordFile = new File("C:\\Users\\emily\\OneDrive\\Desktop\\cs200 proj\\projectRepository\\spring23team1\\src\\Member_Record.txt");

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

                MemberRecord provider = new MemberRecord(name, id, adress, city, state, zip);
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

    public MemberRecord memberAt(Integer ident){
        MemberRecord person = info.get(ident);
        return person;
    }

    public Integer getSize(){
        return info.size();
    }

}
