import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.ArrayList;


public class providerController {

    
    public static void requestProviderDirectory(){
        ProviderDirectory Directory = new ProviderDirectory();
        Directory.requestProviderDirectory();
        for (int i = 0; i < Directory.serviceCodes.size(); i++){
            int code = Directory.serviceCodes.get(i);
            String name = Directory.serviceNames.get(i);
            int fee = Directory.serviceFees.get(i);
            System.out.println(name + " " +  code + " " + fee);
        }
    }

    public static void feeLookup(){
        ProviderDirectory Directory = new ProviderDirectory();
    
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter service code");
        String code = myObj.nextLine();  // Read user input
        int i =Integer.parseInt(code);
        Integer fee = Directory.feeLookup(i);
        System.out.println("Fee is: " + fee);
        myObj.close();
    }

    public static void serviceLookup(){
        ProviderDirectory Directory = new ProviderDirectory();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter service code");
        String code = myObj.nextLine();
        int i = Integer.parseInt(code);
        String service = Directory.serviceLookup(i);
        System.out.println("Service is: " + service);
        myObj.close();
    }

}
