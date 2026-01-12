/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appservice.appservice.services;

import com.appservice.appservice.models.Patient.Patient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appservice.appservice.repositories.PatientRepository;
/**
 *
 * @author Nour
 */
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

   
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
     public Patient getPatientByNationalId(String nationalId) {
     
         return patientRepository.findAll().stream()
            .filter(p -> p.getNationalId().equals(nationalId))
            .findFirst()
            .orElse(null);
    }
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    
}
