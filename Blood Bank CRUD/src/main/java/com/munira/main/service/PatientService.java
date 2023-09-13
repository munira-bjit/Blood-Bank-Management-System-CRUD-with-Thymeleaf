package com.munira.main.service;

import com.munira.main.model.Patient;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PatientService {

    List<Patient> patientList = new ArrayList<>();

    @PostConstruct
    public void init() {
        patientList.add(new Patient(1756, "Nishat Nabila", "B+"));
        patientList.add(new Patient(1757, "Farhana Chowdhury", "AB+"));
        patientList.add(new Patient(1786, "Ashraful Alam", "O+"));
        patientList.add(new Patient(1779, "Niloy Paul", "B+"));
        patientList.add(new Patient(2050, "Tahmina Meem", "O-"));
    }

    public Patient findById(Integer id) {
        for (Patient c : patientList) {
            if (Objects.equals(c.getId(), id))
                return c;
        }
        return null;
    }

    public List<Patient> getAllPatient() {
        return patientList;
    }

    public void addPatient(Patient patient) {
        System.out.println("Adding patient: " + patient.getName());
        patientList.add(patient);
    }

    public void deletePatientById(Integer id) {
        patientList.removeIf(patient -> patient.getId().equals(id));
    }

    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId().equals(updatedPatient.getId())) {
                patientList.set(i, updatedPatient);
                break;
            }
        }
    }
}
