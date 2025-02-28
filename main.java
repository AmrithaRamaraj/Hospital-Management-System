import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;
    String doctor;

    public Patient(int id, String name, int age, String disease, String doctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = doctor;
    }
}

public class HospitalManagement {
    private ArrayList<Patient> patients = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public void addPatient() {
        if (patients.size() >= 100) {
            System.out.println("Hospital is full! Cannot add more patients.");
            return;
        }
        
        int id = patients.size() + 1;
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();
        System.out.print("Enter Doctor Assigned: ");
        String doctor = scanner.nextLine();
        
        patients.add(new Patient(id, name, age, disease, doctor));
        System.out.println("Patient added successfully!");
    }
    
    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found!");
            return;
        }
        
        System.out.println("\nList of Patients:");
        System.out.printf("%-5s %-20s %-5s %-20s %-20s\n", "ID", "Name", "Age", "Disease", "Doctor");
        for (Patient p : patients) {
            System.out.printf("%-5d %-20s %-5d %-20s %-20s\n", p.id, p.name, p.age, p.disease, p.doctor);
        }
    }
    
    public void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Patient Found:");
                System.out.println("ID: " + p.id);
                System.out.println("Name: " + p.name);
                System.out.println("Age: " + p.age);
                System.out.println("Disease: " + p.disease);
                System.out.println("Doctor: " + p.doctor);
                return;
            }
        }
        System.out.println("Patient not found!");
    }
    
    public void mainMenu() {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
    }
    
    public static void main(String[] args) {
        HospitalManagement hospital = new HospitalManagement();
        hospital.mainMenu();
    }
}
