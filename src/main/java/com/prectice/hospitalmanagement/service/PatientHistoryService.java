package com.prectice.hospitalmanagement.service;

import com.prectice.hospitalmanagement.dto.PatientHistoryRequestDTO;
import com.prectice.hospitalmanagement.entity.Doctor;
import com.prectice.hospitalmanagement.entity.Illness;
import com.prectice.hospitalmanagement.entity.Patient;
import com.prectice.hospitalmanagement.entity.PatientHistory;
import com.prectice.hospitalmanagement.repository.DoctorRepository;
import com.prectice.hospitalmanagement.repository.IllnessRepository;
import com.prectice.hospitalmanagement.repository.PatientHistoryRepository;
import com.prectice.hospitalmanagement.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PatientHistoryService {

    private final PatientHistoryRepository patientHistoryRepository;
    private final PatientRepository patientRepository;
    private final IllnessRepository illnessRepository;
    private final DoctorRepository doctorRepository;

    // Get all history records
    public List<PatientHistory> get_all_patient_History(){
        return patientHistoryRepository.findAll();
    }

    // Get history for one patient
    public List<PatientHistory> get_Patient_History_By_Id(Long Id){
        if (!patientHistoryRepository.existsById(Id)){
            throw  new RuntimeException("Patient Not Exits");
        }

        return patientHistoryRepository.findByPatient_Id(Id);

    }


    public PatientHistory createHistory(Long patientId, PatientHistoryRequestDTO request) {

        Patient patient= patientRepository.findById(patientId).orElseThrow(() ->
                new RuntimeException("Patient not found: " + patientId));

        Doctor doctor= doctorRepository.findById(request.getDoctorId()).orElseThrow(() ->
                new RuntimeException("Doctor not found: " + request.getDoctorId()));

        Illness illness= illnessRepository.findById(request.getIllnessId()).orElseThrow(() ->
                new RuntimeException("Illness not found: " + request.getIllnessId()));

        PatientHistory history = new PatientHistory();

        history.setVisitDate(LocalDateTime.now());
        history.setSymptoms(request.getSymptoms());
        history.setDiagnosis(request.getDiagnosis());
        history.setTreatment(request.getTreatment());
        history.setNotes(request.getNotes());
        history.setBloodPressure(request.getBloodPressure());
        history.setFollowUpDate(request.getFollowUpDate());
        history.setTemperature(request.getTemperature());
        history.setWeight(request.getWeight());

        // Set relationships
        history.setPatient(patient);
        history.setDoctor(doctor);
        history.setIllness(illness);

        // Save in database
        return patientHistoryRepository.save(history);
    }
}
