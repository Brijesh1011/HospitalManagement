package com.prectice.hospitalmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



    @Getter
    @Setter
    public class PatientHistoryRequestDTO {

        private Long illnessId;
        private Long doctorId;

        private String symptoms;
        private String diagnosis;
        private String treatment;
        private String notes;
        private String bloodPressure;

        private LocalDate followUpDate;

        private Double temperature;
        private Double weight;


}
