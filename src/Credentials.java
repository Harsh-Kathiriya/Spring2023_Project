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
        return providerCredentialsList.contains(String.valueOf(var));
    }

    public boolean searcOperatorList(Integer var){
        return operatorCredentialsList.contains(String.valueOf(var));
    }


    public Credentials(){
        managerCredentialsList = new ArrayList<String>();
        providerCredentialsList = new ArrayList<String>();
        operatorCredentialsList = new ArrayList<String>();

        try{
            File managerFile = new File("C:\\Users\\emily\\OneDrive\\Desktop\\cs200\\roject4\\credentials\\src\\managerCreds.txt");
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
            File providerFile= new File("C:\\Users\\emily\\OneDrive\\Desktop\\cs200\\roject4\\credentials\\src\\providerCreds.txt");
            Scanner providerReader = new Scanner(providerFile);

            while(providerReader.hasNextLine()) {
                String data = providerReader.nextLine();
                providerCredentialsList.add(data);
            }
            providerReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.printStackTrace();
        }

        try{
            File operatorFile= new File("C:\\Users\\emily\\OneDrive\\Desktop\\cs200\\roject4\\credentials\\src\\operatorCreds.txt");
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
