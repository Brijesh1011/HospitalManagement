package com.prectice.hospitalmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class AppointmentRequestDTO {

    private LocalDateTime appointmentDateTime;
    private String description;

    private Long patientId;
    private Long doctorId;
}
