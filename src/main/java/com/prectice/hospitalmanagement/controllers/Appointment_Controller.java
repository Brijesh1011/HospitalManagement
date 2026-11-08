package com.prectice.hospitalmanagement.controllers;


import com.prectice.hospitalmanagement.dto.AppointmentRequestDTO;
import com.prectice.hospitalmanagement.dto.AppointmentResponseDTO;
import com.prectice.hospitalmanagement.entity.Appointment;
import com.prectice.hospitalmanagement.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/appointment")
@AllArgsConstructor
public class Appointment_Controller {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment(
            @RequestBody AppointmentRequestDTO request
    ){
        try{

            Appointment appointment =
                    appointmentService.createAppointment(request);

            AppointmentResponseDTO response =
                    AppointmentResponseDTO.fromEntity(appointment);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);


        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<?> getPatientAppointments(
            @PathVariable Long patientId) {

        try {
            List<AppointmentResponseDTO> response =
                    appointmentService.getPatientAppointments(patientId)
                            .stream()
                            .map(AppointmentResponseDTO::fromEntity)
                            .toList();

            return ResponseEntity.ok(response);



        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<?> getDoctorAppointment(@PathVariable Long doctorId){

        try{

            List<AppointmentResponseDTO> response =
                    appointmentService.getDoctorAppointment(doctorId)
                            .stream()
                            .map(AppointmentResponseDTO::fromEntity)
                            .toList();

            return ResponseEntity.ok(response);




        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

}
