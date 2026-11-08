package com.prectice.hospitalmanagement.dto;

import com.prectice.hospitalmanagement.entity.PatientHistory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


    @Getter
    @Setter
    public class PatientHistoryResponseDTO {

        private Long id;
        private Long patientId;
        private Long doctorId;
        private Long illnessId;

        private LocalDateTime visitDate;
        private String symptoms;
        private String diagnosis;
        private String treatment;
        private String notes;
        private LocalDate followUpDate;
        private String bloodPressure;
        private Double temperature;
        private Double weight;

        public static PatientHistoryResponseDTO fromEntity(PatientHistory history) {

            PatientHistoryResponseDTO dto = new PatientHistoryResponseDTO();

            dto.setId(history.getId());
            dto.setPatientId(history.getPatient().getId());
            dto.setDoctorId(history.getDoctor().getId());
            dto.setIllnessId(history.getIllness().getId());

            dto.setVisitDate(history.getVisitDate());
            dto.setSymptoms(history.getSymptoms());
            dto.setDiagnosis(history.getDiagnosis());
            dto.setTreatment(history.getTreatment());
            dto.setNotes(history.getNotes());
            dto.setFollowUpDate(history.getFollowUpDate());
            dto.setBloodPressure(history.getBloodPressure());
            dto.setTemperature(history.getTemperature());
            dto.setWeight(history.getWeight());

            return dto;
        }


    }
