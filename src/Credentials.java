import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Credentials{
    public ArrayList<String> managerCredentialsList;
    public ArrayList<String> providerCredentialsList;
    public ArrayList<String> operatorCredentialsList;

    public boolean searchManagerList(Integer var){
        return managerCredentialsList.contains(String.valueOf(var));
    }

    public boolean searchProviderList(Integer var){
        System.out.println("scascsac");
        return providerCredentialsList.contains(String.valueOf(var));
    }

    public boolean searchOperatorList(Integer var){
        return operatorCredentialsList.contains(String.valueOf(var));
    }


    public Credentials(){
        managerCredentialsList = new ArrayList<String>();
        providerCredentialsList = new ArrayList<String>();
        operatorCredentialsList = new ArrayList<String>();
        System.out.println("bbb");
        try{
            File managerFile = new File(System.getProperty("user.dir") + "/managerCreds");
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
            File providerFile= new File(System.getProperty("user.dir") + "/Provider_Record");
            System.out.println("aaa");
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
            File operatorFile= new File(System.getProperty("user.dir") + "/operatorCreds");
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
