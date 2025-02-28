hospital_patients <- data.frame(ID = integer(), Name = character(), Age = integer(), Disease = character(), Doctor = character(), stringsAsFactors = FALSE)

add_patient <- function() {
  id <- ifelse(nrow(hospital_patients) == 0, 1, max(hospital_patients$ID) + 1)
  name <- readline("Enter Patient Name: ")
  age <- as.integer(readline("Enter Age: "))
  disease <- readline("Enter Disease: ")
  doctor <- readline("Enter Doctor Assigned: ")
  
  new_patient <- data.frame(ID = id, Name = name, Age = age, Disease = disease, Doctor = doctor, stringsAsFactors = FALSE)
  assign("hospital_patients", rbind(hospital_patients, new_patient), envir = .GlobalEnv)
  cat("Patient added successfully!\n")
}

view_patients <- function() {
  if (nrow(hospital_patients) == 0) {
    cat("No patients found!\n")
  } else {
    print(hospital_patients)
  }
}

search_patient <- function() {
  id <- as.integer(readline("Enter Patient ID to search: "))
  result <- subset(hospital_patients, ID == id)
  
  if (nrow(result) == 0) {
    cat("Patient not found!\n")
  } else {
    print(result)
  }
}

main_menu <- function() {
  repeat {
    cat("\nHospital Management System\n")
    cat("1. Add Patient\n")
    cat("2. View All Patients\n")
    cat("3. Search Patient\n")
    cat("4. Exit\n")
    choice <- as.integer(readline("Enter your choice: "))
    
    if (choice == 1) {
      add_patient()
    } else if (choice == 2) {
      view_patients()
    } else if (choice == 3) {
      search_patient()
    } else if (choice == 4) {
      cat("Exiting the program.\n")
      break
    } else {
      cat("Invalid choice! Please enter again.\n")
    }
  }
}

main_menu()
