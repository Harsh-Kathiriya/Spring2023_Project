import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class ServiceList {
    HashMap<Integer, Service> serviceMap;
    String serviceListLocation;
    File directoryInfo;
    public ServiceList() {
        try {
            serviceMap = new HashMap<Integer, Service>();
            String userDirectory = System.getProperty("user.dir");
            System.out.println(userDirectory);
            serviceListLocation = userDirectory + "/spring23team1/src/ServiceTest.txt";
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
                    serviceMap.put(tempServiceCodeNum, tempService);
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

    public ArrayList<Service> usersServices(int userNum) {
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
