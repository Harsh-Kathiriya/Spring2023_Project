package classes;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

    /**
        * @author: Emily Curl
        * {@summary: used to search through files that contain credentials to verify a user.}
    */




public class Credentials{
    public ArrayList<String> managerCredentialsList;
    public ArrayList<String> providerCredentialsList;
    public ArrayList<String> operatorCredentialsList;
    public ArrayList<String> memberCredentialsList;

    /**
        * @author: Emily Curl
        * {@summary: used to search through a specified array to verify a user.}
        * @param: integer
        * @return: boolean
    */

    //pass in an integer value to search in the list
    public boolean searchManagerList(Integer var){
        if(var == null){
            throw new IllegalArgumentException("No credentials provided");
        }
        int length = (int) (Math.log10(var) + 1);
        if (length == 0){
            throw new IllegalArgumentException("No credentials provided");
        }
        else{
            if(length < 9){
                throw new IllegalArgumentException("Credentials number is too short. Must be 9 digits");
            }
            else if(length > 9){
                throw new IllegalArgumentException("Credentials number is too long. Must be 9 digits");

            }
        }
        return managerCredentialsList.contains(Integer.toString(var));
    }

    public boolean searchProviderList(Integer var){
        return providerCredentialsList.contains(String.valueOf(var));
    }

    public boolean searchOperatorList(Integer var){
        return operatorCredentialsList.contains(String.valueOf(var));
    }
    public boolean searchMemberList(Integer var){
        return memberCredentialsList.contains(String.valueOf(var));
    }
//

    

    /**
        * @author: Emily Curl
        * {@summary: reads in 4 files and creates an array of different credentials for different users.}
    */

//
    public Credentials(){
        managerCredentialsList = new ArrayList<String>();
        providerCredentialsList = new ArrayList<String>();
        operatorCredentialsList = new ArrayList<String>();
        memberCredentialsList = new ArrayList<String>();
        try{
            File managerFile = new File("./data/managerCreds");
            Scanner managerReader = new Scanner(managerFile);
            while(managerReader.hasNextLine()) {
                String data = managerReader.nextLine();
                managerCredentialsList.add(data);
            }
            managerReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.printStackTrace();
        }

        try{
            File providerFile = new File("./data/Provider_Record");
            Scanner providerReader = new Scanner(providerFile);

            while(providerReader.hasNextLine()) {
                String data = providerReader.nextLine();
                String[] temp = data.split(",");
                providerCredentialsList.add(temp[0]);
            }
            providerReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.printStackTrace();
        }

        try{
            File memberFile= new File("./data/Member_Record");
            Scanner memberReader = new Scanner(memberFile);

            while(memberReader.hasNextLine()) {
                String data = memberReader.nextLine();
                String[] temp = data.split(",");
                memberCredentialsList.add(temp[0]);
            }
            memberReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.printStackTrace();
        }
        try{
            File operatorFile= new File("./data/operatorCreds");
            Scanner operatorReader = new Scanner(operatorFile);

            while(operatorReader.hasNextLine()) {
                String data = operatorReader.nextLine();
                operatorCredentialsList.add(data);
            }
            operatorReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Credentials test = new Credentials();
        boolean search = test.searchManagerList(123456789);
        if (search == false){
            System.out.println("search not valid");
        }
        
    }

}
