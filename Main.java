import java.util.Scanner;


public class Main {
    public static void main(String[] args) { 
        // Tinatawag ang repository base sa diagram
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

            // Paggamit ng Builder Pattern mula sa diagram
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

            // I-save sa database
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