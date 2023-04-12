import java.util.ArrayList;
import java.util.Scanner;

class TestRunner {
    public static void main(String[] args){
        ArrayList<ProviderRecord> prs = new ArrayList<ProviderRecord>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a number (1) for add:  (2) for print: ");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    // prompt for new record info
                    // create new record
                    // add to arraylist
                    System.out.print("Please enter the name: ");
                    String name = in.nextLine();
                    System.out.print("Please enter the number: ");
                    String number = in.nextLine();
                    System.out.print("Please enter the address: ");
                    String address = in.nextLine();
                    System.out.print("Please enter the city: ");
                    String city = in.nextLine();
                    System.out.print("Please enter the state: ");
                    String state = in.nextLine();
                    System.out.print("Please enter the zip code: ");
                    String zipCode = in.nextLine();
                    ProviderRecord record = new ProviderRecord(name, number, address, city, state, zipCode);
                    prs.add(record);
                    break;
                case 2:
                //print
                    for (int i = 0; i < prs.size(); i++) {
                        System.out.println(prs.get(i).getName());
                        System.out.println(prs.get(i).getNumber());
                        System.out.println(prs.get(i).getAddress());
                        System.out.println(prs.get(i).getCity());
                        System.out.println(prs.get(i).getState());
                        System.out.println(prs.get(i).getZipCode());
                    }
                    break;
            
                default:
                    break;
            }
        }
        // ProviderRecord record = new ProviderRecord("name", 123, "address", "city", "state", "zipCode");
        // prs.add(record);
        // System.out.println(prs.get(0).getName());
        // System.out.println(prs.get(0).getNumber());
        // System.out.println(prs.get(0).getAddress());
        // System.out.println(prs.get(0).getCity());
        // System.out.println(prs.get(0).getState());
        // System.out.println(prs.get(0).getZipCode());

        // prs.get(0).setName("new name");
        // System.out.println(prs.get(0).getName());

    }
}