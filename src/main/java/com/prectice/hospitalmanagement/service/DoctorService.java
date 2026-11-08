package com.prectice.hospitalmanagement.service;

import com.prectice.hospitalmanagement.dto.DoctorRequest;
import com.prectice.hospitalmanagement.dto.DoctorResponse;
import com.prectice.hospitalmanagement.entity.Doctor;
import com.prectice.hospitalmanagement.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Builder
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<DoctorResponse> All_Doctor(){
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> DoctorResponse.builder()
                        .id(doctor.getId())
                        .name(doctor.getName())
                        .number(doctor.getNumber())
                        .email(doctor.getEmail())
                        .doctorType(doctor.getDoctorType())
                        .joining_date(doctor.getJoining_date())
                        .build()
                ).toList();
    }
//-------------------------------------------------------
    public DoctorResponse addDoctor(DoctorRequest request) {

        if(doctorRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Doctor is alredy exist");
        }

        if(doctorRepository.existsByNumber(request.getNumber())){
            throw  new RuntimeException("Doctor is already exist");
        }

        Doctor doctor=new Doctor();
        doctor.setName(request.getName());
        doctor.setNumber(request.getNumber());
        doctor.setEmail(request.getEmail());
        doctor.setDoctorType(request.getDoctorType());

        Doctor savedDoctor= doctorRepository.save(doctor);

        return DoctorResponse.builder()
                .id(savedDoctor.getId())
                .name(savedDoctor.getName())
                .number(savedDoctor.getNumber())
                .email(savedDoctor.getEmail())
                .doctorType(savedDoctor.getDoctorType())
                .joining_date(savedDoctor.getJoining_date())
                .build();
    }

    //---------------------------------------------------------
    public DoctorResponse Doctor_by_id(Long id) {

        Doctor doctor= doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found with id: " + id));

        return DoctorResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .number(doctor.getNumber())
                .doctorType(doctor.getDoctorType())
                .joining_date(doctor.getJoining_date())
                .build();
    }

//-------------------------------------------------------------
    public void Delete_by_id(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }

        doctorRepository.deleteById(id);
    }

    //---------------------------------
    public DoctorResponse Upadate_by_id(Long id, DoctorRequest request ){

        Doctor existing_doctor=doctorRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor not found with id: "+id));

        if (request.getName() != null) {
            existing_doctor.setName(request.getName());
        }

        if (request.getNumber() != null) {
            existing_doctor.setNumber(request.getNumber());
        }

        if (request.getEmail() != null) {
            existing_doctor.setEmail(request.getEmail());
        }

        if (request.getDoctorType() != null) {
            existing_doctor.setDoctorType(request.getDoctorType());
        }

        Doctor updated_doctor = doctorRepository.save(existing_doctor);

        return DoctorResponse.builder()
                .id(updated_doctor.getId())
                .name(updated_doctor.getName())
                .number(updated_doctor.getNumber())
                .email(updated_doctor.getEmail())
                .doctorType(updated_doctor.getDoctorType())
                .joining_date(updated_doctor.getJoining_date())
                .build();

    }

}
