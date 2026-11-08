
package com.prectice.hospitalmanagement.dto;

import com.prectice.hospitalmanagement.entity.Appointment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponseDTO {

    private Long id;
    private LocalDateTime appointmentDateTime;
    private String description;

    private Long doctorId;
    private String doctorName;
    private String doctorNumber;

    private Long patientId;
    private String patientName;
    private String patientContactNumber;

    public static AppointmentResponseDTO fromEntity(Appointment appointment) {

        AppointmentResponseDTO dto = new AppointmentResponseDTO();

        dto.setId(appointment.getId());
        dto.setAppointmentDateTime(appointment.getAppoinmentdateTime());
        dto.setDescription(appointment.getDescription());

        // Doctor details
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setDoctorName(appointment.getDoctor().getName());
        dto.setDoctorNumber(appointment.getDoctor().getNumber());

        // Patient details
        dto.setPatientId(appointment.getPatient().getId());
        dto.setPatientName(appointment.getPatient().getName());
        dto.setPatientContactNumber(
                appointment.getPatient().getContactNumber()
        );

        return dto;
    }
}

