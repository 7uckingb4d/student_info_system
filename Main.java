import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) { 

        repository repo = new repository(); 
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        
        while (isRunning) {
            System.out.println("\n=== STUDENT REGISTRATION SYSTEM ===");
            System.out.print("1. Student ID: "); int id = Integer.parseInt(sc.nextLine());
            System.out.print("2. First Name: "); String fn = sc.nextLine();
            System.out.print("3. Last Name: "); String ln = sc.nextLine();
            System.out.print("4. Middle Name: "); String mn = sc.nextLine();
            System.out.print("5. Year Level: "); int yr = Integer.parseInt(sc.nextLine());
            System.out.print("6. Section: "); String sec = sc.nextLine();
            System.out.print("7. Program: "); String pr = sc.nextLine();
            System.out.print("8. Address: "); String ad = sc.nextLine();
            System.out.print("9. Email: "); String em = sc.nextLine();
            System.out.print("10. Phone: "); String ph = sc.nextLine();

            studentInfo s = new studentInfo.StudentBuilder()
                    .setSTUDID(id)
                    .setSTUDFNAME(fn)
                    .setSTUDLNAME(ln)
                    .setSTUDMNAME(mn)
                    .setSTUDYEAR(yr)
                    .setSTUDSECTION(sec)
                    .setSTUDPROG(pr)
                    .setSTUDADDRESS(ad)
                    .setSTUDEMAIL(em)
                    .setSTUDPHONE(ph)
                    .BuildStudent();

            repo.insertStudent(s);

            OUTER:
            while (true) {
                System.out.print("\nMag-a-add ka pa ba ng iba? (1 - Yes / 2 - No): ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1" -> {
                        break OUTER;
                    }
                    case "2" -> {
                        isRunning = false;
                        break OUTER;
                    }
                }
            }
        }
        
        List<studentInfo> masterList = repo.getAllStudents();
        
        System.out.println("\n=== MASTER LIST OF STUDENTS (FROM SQLITE DATABASE) ===");
        System.out.println("========================================================================================================================================================================");
        System.out.printf("%-10s %-15s %-15s %-15s %-10s %-10s %-15s %-30s %-20s %-15s\n", 
            "ID", "First Name", "Last Name", "Middle Name", "Year", "Section", "Program", "Address", "Email", "Phone");
        System.out.println("========================================================================================================================================================================");
        
        for (studentInfo s : masterList) {
            System.out.printf("%-10d %-15s %-15s %-15s %-10d %-10s %-15s %-30s %-20s %-15s\n", 
                s.getSTUDID(), 
                s.getSTUDFNAME(), 
                s.getSTUDLNAME(), 
                s.getSTUDMNAME(), 
                s.getSTUDYEAR(), 
                s.getSTUDSECTION(), 
                s.getSTUDPROG(), 
                s.getSTUDADDRESS(), 
                s.getSTUDEMAIL(), 
                s.getSTUDPHONE());
        }
        System.out.println("========================================================================================================================================================================");
        
        System.out.println("System Closed.");
        sc.close();
    }
}
