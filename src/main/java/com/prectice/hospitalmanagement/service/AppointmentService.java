package com.prectice.hospitalmanagement.service;

import com.prectice.hospitalmanagement.dto.AppointmentRequestDTO;
import com.prectice.hospitalmanagement.entity.Appointment;
import com.prectice.hospitalmanagement.entity.Doctor;
import com.prectice.hospitalmanagement.entity.Patient;
import com.prectice.hospitalmanagement.repository.AppointmentRepository;
import com.prectice.hospitalmanagement.repository.DoctorRepository;
import com.prectice.hospitalmanagement.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private  final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;




    public Appointment createAppointment(AppointmentRequestDTO request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() ->
                        new RuntimeException("Patient not found: " + request.getPatientId()));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found: " + request.getDoctorId()));

        Appointment appointment = new Appointment();

        appointment.setAppoinmentdateTime(request.getAppointmentDateTime());
        appointment.setDescription(request.getDescription());

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }


    public List<Appointment> getPatientAppointments(Long patientId) {

        if (!patientRepository.existsById(patientId)) {
            throw new RuntimeException("Patient not found");
        }

        return appointmentRepository.findByPatient_Id(patientId);

    }

    public List<Appointment> getDoctorAppointment(Long doctorId) {
        if (!doctorRepository.existsById(doctorId)){
            throw new RuntimeException("doctor not found");
        }
        return  appointmentRepository.findByDoctor_Id(doctorId);
    }

}
