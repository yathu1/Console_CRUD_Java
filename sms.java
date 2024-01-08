import java.util.Arrays;
import java.util.Scanner;

public class sms {
    static String[][] adminList = new String[10][2];
    static String[][] studentList = new String[50][6];
    static String[][] tempList = new String[50][6];

    public static void Home() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Home | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("1- Register as an admin");
        System.out.println("2- Login as an admin");
        System.out.println("\nEnter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Register();
                break;
            case 2:
                login();
                break;
            default:
                System.out.print("\033[H\033[2J");
                System.out.println("Invalid choice. try again");
                Home();
                break;
        }
        sc.close();
    }

    public static void Register() {
        System.out.print("\033[H\033[2J");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Register Admin | ");
        System.out.println("  -------------------------------------------- ");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter admin name: ");
        String adminName = sc.nextLine();
        System.out.println("Enter admin Password: ");
        String adminPass = sc.nextLine();

        if (adminName == null || adminName.isEmpty() ||
                adminPass == null || adminPass.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.println("Please fill all the fields");
            Register();
        }

        int index = 0;
        for (int i = 0; i < adminList.length; i++) {
            if (adminList[i][0] == null) {
                index = i;
                break;
            }
        }
        adminList[index][0] = adminName;
        adminList[index][1] = adminPass;

        System.out.println("Successfully done \n" + Arrays.toString(adminList[index]));
        login();

    }

    public static void login() {
        // String sysUserName = "admin";
        // String sysPassword= "admin";

        System.out.println("---------------------------");
        System.out.println("Welcome to the Student Management System");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Log In | ");
        System.out.println("  -------------------------------------------- ");

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter username: ");
        String userName = sc.nextLine();
        System.out.print("\nEnter password: ");
        String password = sc.nextLine();

        boolean isValid = false;

        for (int j = 0; j < adminList.length; j++) {
            if (userName.equals(adminList[j][0]) && password.equals(adminList[j][1])) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            System.out.print("\033[H\033[2J");
            System.out.println("\nWelcome to the system");
            dashboard();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("\nUsername or password wrong. Please try again");
            login();
        }

        sc.close();

    }

    public static void dashboard() {

        Scanner sc = new Scanner(System.in);
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("1- Save New Student");
        System.out.println("2- Edit New Student");
        System.out.println("3- View All Students");
        System.out.println("4- Search Student");
        System.out.println("5- Remove Student");
        System.out.println("6- Logout\n");

        System.out.println("\nEnter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                saveStudent();
                break;
            case 2:
                editStudent();
                break;
            case 3:
                viewAllStudents();
                break;
            case 4:
                searchStudent();
                break;
            case 5:
                removeStudent();
                break;
            case 6:
                // System.exit(0);
                Home();
                ;
                break;

            default:
                System.out.print("\033[H\033[2J");
                System.out.println("Invalid choice. try again");
                dashboard();
                break;
        }
    }

    public static void saveStudent() {
        System.out.print("\033[H\033[2J");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Save Student | ");
        System.out.println("  -------------------------------------------- ");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter student Nic: ");
        String nic = sc.nextLine();
        System.out.println("Enter student age: ");
        String age = sc.nextLine();
        System.out.println("Enter student Contact No: ");
        String contactNo = sc.nextLine();
        System.out.println("Enter student Gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter student DOB: ");
        String dob = sc.nextLine();

        if (name == null || name.isEmpty() ||
                nic == null || nic.isEmpty() ||
                age == null || age.isEmpty() ||
                contactNo == null || contactNo.isEmpty() ||
                gender == null || gender.isEmpty() ||
                dob == null || dob.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.println("Please fill all the fields");
            saveStudent();
        }

        int index = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][0] == null) {
                index = i;
                break;
            }
        }
        studentList[index][0] = name;
        studentList[index][1] = nic;
        studentList[index][2] = age;
        studentList[index][3] = contactNo;
        studentList[index][4] = gender;
        studentList[index][5] = dob;

        System.out.println("Successfully done \n" + Arrays.toString(studentList[index]));
        System.out.println("Do You Want to save another student? press Y or press any letter)");
        String selection = sc.nextLine();
        if (selection.equalsIgnoreCase("Y")) {
            saveStudent();
        } else {
            System.out.print("\033[H\033[2J");
            dashboard();
        }
    }

    public static void viewAllStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | View All Students | ");
        System.out.println("  -------------------------------------------- ");

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][0] != null) {
                System.out.println(Arrays.toString(studentList[i]));
            } else {
                break;
            }
        }

        System.out.println("\n press any letter to continue to dashboard \n");
        String selection = sc.nextLine();
        if (selection != null) {
            System.out.print("\033[H\033[2J");
            dashboard();
        }
    }

    public static void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  ------------------ ");
        System.out.println("  | Search Student | ");
        System.out.println("  ------------------ ");

        System.out.println("Enter Student Nic Number:");
        String nic = sc.nextLine();

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][1].equals(nic)) {
                System.out.println("\n" + Arrays.toString(studentList[i]));
                break;
            }
        }
        System.out.println("\n press any letter to continue to dashboard \n");
        String selection = sc.nextLine();
        if (selection != null) {
            System.out.print("\033[H\033[2J");
            dashboard();
        }

    }

    public static void removeStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  ------------------ ");
        System.out.println("  | Remove Student | ");
        System.out.println("  ------------------ ");

        System.out.println("Enter Student Nic Number:");
        String nic = sc.nextLine();

        int index = -1;
        for (int i = 0; i < studentList.length; i++) {

            if (studentList[i][1].equals(nic)) {
                index = i;
                break;
            }
        }
        int x = 0;
        for (int k = 0; k < studentList.length; k++) {
            if (k == index) {
                continue;
            }

            tempList[x] = studentList[k];
            x++;
        }

        studentList = tempList;

        System.out.println("\n press any letter to continue to dashboard \n");
        String selection = sc.nextLine();
        if (selection != null) {
            System.out.print("\033[H\033[2J");
            dashboard();
        }

    }

    public static void editStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  | Welcome to the student management system | ");
        System.out.println("  -------------------------------------------- ");
        System.out.println("  ------------------ ");
        System.out.println("  | Edit Student | ");
        System.out.println("  ------------------ ");

        System.out.println("Enter Student Nic Number:");
        String nic = sc.nextLine();

        int index = -1;

        for (int i = 0; i < studentList.length; i++) {

            if (studentList[i][1].equals(nic)) {
                index = i;
                break;
            }
        }
        System.out.println(Arrays.toString(studentList[index]) + "\n");

        System.out.println("Which field to be edit?");
        System.out.println("0 - Name");
        System.out.println("1 - Nic");
        System.out.println("2 - Age");
        System.out.println("3 - ContactNo");
        System.out.println("4 - Gender");
        System.out.println("5 - DOB");

        int choice = sc.nextInt();
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 0:
                System.out.println("Enter new name:");
                String name = scanner.nextLine();
                studentList[index][0] = name;
                break;
            case 1:
                System.out.println("Enter new Nic");
                String nicNo = scanner.nextLine();
                studentList[index][1] = nicNo;
                break;
            case 2:
                System.out.println("Enter new Age");
                String age = scanner.nextLine();
                studentList[index][2] = age;
                break;
            case 3:
                System.out.println("Enter new Contact No");
                String cno = scanner.nextLine();
                studentList[index][3] = cno;
                break;
            case 4:
                System.out.println("Enter new Gender");
                String gender = scanner.nextLine();
                studentList[index][4] = gender;
                break;
            case 5:
                System.out.println("Enter new DOB");
                String dob = scanner.nextLine();
                studentList[index][5] = dob;
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
        System.out.println("\n press any letter to continue to dashboard \n");
        String selection = sc.nextLine();
        if (selection != null) {
            System.out.print("\033[H\033[2J");
            dashboard();
        }
    }

    public static void main(String[] args) {

        Home();
    }
}
