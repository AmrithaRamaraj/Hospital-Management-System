import sys

class Patient:
    def __init__(self, id, name, age, disease, doctor):
        self.id = id
        self.name = name
        self.age = age
        self.disease = disease
        self.doctor = doctor

class Hospital:
    def __init__(self):
        self.patients = []
    
    def add_patient(self):
        if len(self.patients) >= 100:
            print("Hospital is full! Cannot add more patients.")
            return
        
        id = len(self.patients) + 1
        name = input("Enter Patient Name: ")
        age = int(input("Enter Age: "))
        disease = input("Enter Disease: ")
        doctor = input("Enter Doctor Assigned: ")
        
        self.patients.append(Patient(id, name, age, disease, doctor))
        print("Patient added successfully!")
    
    def view_patients(self):
        if not self.patients:
            print("No patients found!")
            return
        
        print("\nList of Patients:")
        print("ID\tName\t\tAge\tDisease\t\tDoctor")
        for p in self.patients:
            print(f"{p.id}\t{p.name}\t{p.age}\t{p.disease}\t{p.doctor}")
    
    def search_patient(self):
        id = int(input("Enter Patient ID to search: "))
        for p in self.patients:
            if p.id == id:
                print("Patient Found:")
                print(f"ID: {p.id}\nName: {p.name}\nAge: {p.age}\nDisease: {p.disease}\nDoctor: {p.doctor}")
                return
        print("Patient not found!")
    
    def main_menu(self):
        while True:
            print("\nHospital Management System")
            print("1. Add Patient")
            print("2. View All Patients")
            print("3. Search Patient")
            print("4. Exit")
            choice = int(input("Enter your choice: "))
            
            if choice == 1:
                self.add_patient()
            elif choice == 2:
                self.view_patients()
            elif choice == 3:
                self.search_patient()
            elif choice == 4:
                print("Exiting the program.")
                sys.exit()
            else:
                print("Invalid choice! Please enter again.")

if __name__ == "__main__":
    hospital = Hospital()
    hospital.main_menu()
