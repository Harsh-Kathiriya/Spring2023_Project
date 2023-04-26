import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


class EFTRecord {
    // initializing fields
    private String EFTLocation;
    private String providerName;
    private int providerNumber;
    private int transferAmount;
    // default constructor does not intialize any values
    EFTRecord() {

    }

    // Constructor that provides all fields of the report
    public EFTRecord(String providerName, int providerNumber, int transferAmount) {
        this.providerName = providerName;
        this.providerNumber = providerNumber;
        this.transferAmount = transferAmount;
        try {
            String userDirectory = System.getProperty("user.dir");
            EFTLocation = userDirectory + "/spring23team1/src/" + providerName + ".txt";
            FileWriter EFTWriter = new FileWriter(EFTLocation);
            EFTWriter.write(providerName + " " + Integer.toString(providerNumber) +  " " + Integer.toString(transferAmount));
            EFTWriter.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("FileError");
        }
        catch(IOException e) {
            System.out.println("IOError");
        }
    }

    public String getProviderName() {
        return providerName;
    }

    public int getProviderNumber() {
        return providerNumber;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    
}