import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ManagerController {

    // TO DO:
    // Get report type
    // Read info report info
    // Create new file
    // Paste report info onto file
    // Return to menu

    int reportType;
    String reportInfo;

    public void setReportType(int reportNum){
        // 1 is Summary
        // 2 is EFT
        // 3 is Provider
        // 4 is Member
        this.reportType = reportNum;
    }

    public void setReportInfo(String reportInfo){
        if(reportType == 1){

        }

        if(reportType == 2){
            
        }

        if(reportType == 3){
            
        }

        if(reportType == 4){
            
        }
    }

    public String getReport(){
        return this.reportInfo;
    }

    public class ReadFile {
        public static void main(String[] args) {
          try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }
      }

    public class CreateReport {
        public static void main(String[] args) {
          try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }
      }


    public class DeleteFile {
        public static void main(String[] args) { 
            File myObj = new File("filename.txt"); 
                if (myObj.delete()) { 
            System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            } 
        } 
    }

    public void setReportInfos(String reportInfos){
        if(reportType == 1){
            CreateReport(1);
    }
}

    private void CreateReport(int i) {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
