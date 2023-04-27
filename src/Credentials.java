import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Credentials{
    public ArrayList<String> managerCredentialsList;
    public ArrayList<String> providerCredentialsList;
    public ArrayList<String> operatorCredentialsList;
    public ArrayList<String> memberCredentialsList;

    public boolean searchManagerList(Integer var){
        System.out.print("variable " + Integer.toString(var));
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


    public Credentials(){
        managerCredentialsList = new ArrayList<String>();
        providerCredentialsList = new ArrayList<String>();
        operatorCredentialsList = new ArrayList<String>();
        memberCredentialsList = new ArrayList<String>();
        try{
            File managerFile = new File(System.getProperty("user.dir") + "/src/managerCreds");
            System.out.println("null");
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
            File providerFile= new File(System.getProperty("user.dir") + "/src/Provider_Record");
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
            File memberFile= new File(System.getProperty("user.dir") + "/src/Member_Record");
            Scanner memberReader = new Scanner(memberFile);

            while(memberReader.hasNextLine()) {
                String data = memberReader.nextLine();
                String[] temp = data.split(",");
                System.out.println(temp[0]);
                memberCredentialsList.add(temp[0]);
            }
            memberReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.printStackTrace();
        }
        try{
            File operatorFile= new File(System.getProperty("user.dir") + "/src/operatorCreds");
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

}
