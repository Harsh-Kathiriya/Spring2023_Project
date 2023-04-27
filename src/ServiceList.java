import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * {@summary ServiceList is a class that contains a hashmap of services provided during the week}
 */
public class ServiceList {
    HashMap<Integer, Service> serviceMap;
    String serviceListLocation;
    File directoryInfo;
    /**
     * {@summary Default constructor that reads in the services from a file}
     */
    public ServiceList() {
        try {
            serviceMap = new HashMap<Integer, Service>();
            String userDirectory = System.getProperty("user.dir");
            System.out.println(userDirectory);
            serviceListLocation = userDirectory + "/src/ServiceTest.txt";
            directoryInfo = new File(serviceListLocation);
            if(directoryInfo.createNewFile()) {
                System.out.println("Service List Created");
            }
            else {
                Scanner readIn = new Scanner(directoryInfo);
                

                int tempCurrentDateNum;

                int tempDateProvidedNum;

                int tempProviderNumberNum;

                int tempMemberNumberNum;

                int tempServiceCodeNum;

                String tempComments;
                Service tempService;

                while(readIn.hasNextLine()){
                    String temp = readIn.nextLine();
                    String[] arr = temp.split(",");

                    tempCurrentDateNum = Integer.parseInt(arr[0]);
                    tempDateProvidedNum = Integer.parseInt(arr[1]);
                    tempProviderNumberNum = Integer.parseInt(arr[2]);
                    tempMemberNumberNum = Integer.parseInt(arr[3]);
                    tempServiceCodeNum = Integer.parseInt(arr[4]);
                    tempComments = arr[5];
                    tempService = new Service(tempCurrentDateNum,tempDateProvidedNum,tempProviderNumberNum,tempMemberNumberNum,tempServiceCodeNum,tempComments);
                    serviceMap.put(serviceMap.size(), tempService);
                }
                readIn.close();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Error");
        }
        catch(IOException e) {
            System.out.println("Error");
        }
    }
    /**
     * {@summary serviceAt returns a service at a position in the hashmap}
     * @param pos
     * @return
     */
    public Service serviceAt(int pos) {
        Iterator serviceMapIterator = serviceMap.entrySet().iterator();
        Service currentService = null;
        int counter = 0;
        while(serviceMapIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)serviceMapIterator.next();
            currentService = (Service)mapElement.getValue();
            if(counter == pos) {
                break;
            }
            counter++;
        }
        return currentService;
    }
    /**
     * {@summary usersServices returns an arraylist of services for a provider or member}
     * @param userNum
     * @return
     */
    public ArrayList<Service> usersServices(int userNum) {
        System.out.println("WorkingService");
        ArrayList<Service> services = new ArrayList<Service>();
        Iterator serviceMapIterator = serviceMap.entrySet().iterator();
        Service currentService = null;
        while(serviceMapIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)serviceMapIterator.next();
            currentService = (Service)mapElement.getValue();
            if((userNum == currentService.getMemberNum()) || (userNum == currentService.getProviderNum())) {
                services.add(currentService);
            }
        }
        return services;
    }
    /** 
     * {@summary getSize gets the amount of services in the hashmap}
     */
    public int getSize() {
        return serviceMap.size();
    }

    public void addService(int currentDate, int dateProvided, int providerNum, int memberNum, int serviceCode, String comments) {
        Service tempService;
        try {
            FileWriter serviceWriter = new FileWriter(serviceListLocation);
            serviceWriter.write(Integer.toString(currentDate) + " " + Integer.toString(dateProvided) + " " + Integer.toString(providerNum) + " " + Integer.toString(memberNum) + " " + Integer.toString(serviceCode) + " " + comments + "\n");
            serviceWriter.close();
        }
        catch(IOException e) {
            System.out.println("Error");
        }
        if(comments == "") {
            tempService = new Service(currentDate,dateProvided,providerNum,memberNum,serviceCode);
        }
        else {
            tempService = new Service(currentDate,dateProvided,providerNum,memberNum,serviceCode,comments);
        }
        serviceMap.put(serviceCode,tempService);
    }


    public static void main(String[] args) {
        ServiceList serviceList = new ServiceList();
        System.out.println(serviceList.serviceAt(0).getCurrentDate());
        //serviceList.addService(0, 0, 0, 0, 0, null);
    }



}
