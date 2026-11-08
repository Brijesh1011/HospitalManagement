package com.prectice.hospitalmanagement.service;

import com.prectice.hospitalmanagement.dto.PatientRequest;
import com.prectice.hospitalmanagement.dto.PatientResponse;
import com.prectice.hospitalmanagement.entity.Patient;
import com.prectice.hospitalmanagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientResponse> get_all_patient(){
        return patientRepository.findAll()
                .stream()
                .map(patient -> PatientResponse.builder()
                        .id(patient.getId())
                        .name(patient.getName())
                        .birthdate(patient.getBirthdate())
                        .email(patient.getEmail())
                        .gender(patient.getGender())
                        .bloodGroup(patient.getBloodGroup())
                        .contactNumber(patient.getContactNumber())
                        .createAt(patient.getCreateAt())
                        .build())
                .toList();
    }

    public PatientResponse get_patient_by_id(Long id){

        Patient patient= patientRepository.findById(id).orElseThrow(()->new RuntimeException("patient not found"));

        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .birthdate(patient.getBirthdate())
                .email(patient.getEmail())
                .gender(patient.getGender())
                .bloodGroup(patient.getBloodGroup())
                .contactNumber(patient.getContactNumber())
                .createAt(patient.getCreateAt())
                .build();
    }


    public PatientResponse addPatient(PatientRequest request) {
        if (patientRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");

        }

        if (patientRepository.existsByContactNumber(request.getContactNumber())) {
            throw new RuntimeException("Contact Number already exists");
        }
        Patient patient= Patient.builder()
                .name(request.getName())
                .birthdate(request.getBirthdate())
                .email(request.getEmail())
                .gender(request.getGender())
                .bloodGroup(request.getBloodGroup())
                .contactNumber(request.getContactNumber())
                .build();

        Patient savedPatient = patientRepository.save(patient);

        return PatientResponse.builder()
                .id(savedPatient.getId())
                .name(savedPatient.getName())
                .birthdate(savedPatient.getBirthdate())
                .email(savedPatient.getEmail())
                .gender(savedPatient.getGender())
                .bloodGroup(savedPatient.getBloodGroup())
                .contactNumber(savedPatient.getContactNumber())
                .createAt(savedPatient.getCreateAt())
                .build();
    }


    public void delete_Patient_By_id(Long id) {
        if(!patientRepository.existsById(id)){
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }

    public PatientResponse update_data_of_patient(Long id, PatientRequest request) {
        Patient existing_patient=patientRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Patient not found with id: " + id)
        );

        if(request.getName()!=null){
            existing_patient.setName(request.getName());
        }
        if (request.getEmail() != null) {
            existing_patient.setEmail(request.getEmail());
        }
        Patient updated_patient = patientRepository.save(existing_patient);

        return PatientResponse.builder()
                .id(updated_patient.getId())
                .name(updated_patient.getName())
                .birthdate(updated_patient.getBirthdate())
                .email(updated_patient.getEmail())
                .gender(updated_patient.getGender())
                .bloodGroup(updated_patient.getBloodGroup())
                .contactNumber(updated_patient.getContactNumber())
                .createAt(updated_patient.getCreateAt())
                .build();
    }

}




