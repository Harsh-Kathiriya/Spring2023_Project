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

    public static int feeLookup(int code){
        ProviderDirectory Directory = new ProviderDirectory();
        //System.out.println("Enter service code");
        Integer fee = Directory.feeLookup(code);
        return fee;
    }

    public static String serviceLookup(int code){
        ProviderDirectory Directory = new ProviderDirectory();
        String service = Directory.serviceLookup(code);
        return service;
    }

}
