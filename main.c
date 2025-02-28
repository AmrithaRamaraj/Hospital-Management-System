#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_PATIENTS 100

struct Patient {
    int id;
    char name[50];
    int age;
    char disease[100];
    char doctor[50];
};

struct Patient patients[MAX_PATIENTS];
int patientCount = 0;

void addPatient() {
    if (patientCount >= MAX_PATIENTS) {
        printf("Hospital is full! Cannot add more patients.\n");
        return;
    }
    
    struct Patient p;
    p.id = patientCount + 1;
    printf("Enter Patient Name: ");
    scanf(" %[^"]", p.name);
    printf("Enter Age: ");
    scanf("%d", &p.age);
    printf("Enter Disease: ");
    scanf(" %[^"]", p.disease);
    printf("Enter Doctor Assigned: ");
    scanf(" %[^"]", p.doctor);
    
    patients[patientCount++] = p;
    printf("Patient added successfully!\n");
}

void viewPatients() {
    if (patientCount == 0) {
        printf("No patients found!\n");
        return;
    }
    
    printf("\nList of Patients:\n");
    printf("ID\tName\t\tAge\tDisease\t\tDoctor\n");
    for (int i = 0; i < patientCount; i++) {
        printf("%d\t%s\t%d\t%s\t%s\n", patients[i].id, patients[i].name, patients[i].age, patients[i].disease, patients[i].doctor);
    }
}

void searchPatient() {
    int id;
    printf("Enter Patient ID to search: ");
    scanf("%d", &id);
    
    for (int i = 0; i < patientCount; i++) {
        if (patients[i].id == id) {
            printf("Patient Found:\n");
            printf("ID: %d\nName: %s\nAge: %d\nDisease: %s\nDoctor: %s\n", patients[i].id, patients[i].name, patients[i].age, patients[i].disease, patients[i].doctor);
            return;
        }
    }
    printf("Patient not found!\n");
}

void mainMenu() {
    int choice;
    do {
        printf("\nHospital Management System\n");
        printf("1. Add Patient\n");
        printf("2. View All Patients\n");
        printf("3. Search Patient\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
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
                printf("Exiting the program.\n");
                exit(0);
            default:
                printf("Invalid choice! Please enter again.\n");
        }
    } while (1);
}

int main() {
    mainMenu();
    return 0;
}
