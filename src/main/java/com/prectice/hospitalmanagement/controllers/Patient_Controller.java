package com.prectice.hospitalmanagement.controllers;

import com.prectice.hospitalmanagement.dto.PatientRequest;
import com.prectice.hospitalmanagement.dto.PatientResponse;
import com.prectice.hospitalmanagement.entity.Patient;
import com.prectice.hospitalmanagement.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patient")
@AllArgsConstructor
public class Patient_Controller {

    private final PatientService patientService;



    @GetMapping
    public ResponseEntity<?> get_all_patients(){

        try{
            List<PatientResponse> all_patient=patientService.get_all_patient();
            return ResponseEntity.ok(Map.of(
                    "message", "Patients fetched successfully",
                    "data", all_patient
            ));
        }
        catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/add_patient")
    public ResponseEntity<?> add_patient(@RequestBody PatientRequest request){
        try{
            PatientResponse savePatient=patientService.addPatient(request);
            return ResponseEntity.ok(savePatient);
        }
        catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get_patient_by_id(@PathVariable Long id){
        try {
            PatientResponse patient_by_id=patientService.get_patient_by_id(id);
            return ResponseEntity.ok(patient_by_id);

        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    };

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete_Patient_By_id(@PathVariable Long id){
        try{
            patientService.delete_Patient_By_id(id);

            return ResponseEntity.ok("Patient deleted Successfully");

        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> upadte_data_of_patient(@PathVariable Long id ,@RequestBody PatientRequest request){

        try{
            PatientResponse updateddata=patientService.update_data_of_patient(id,request);
            return  ResponseEntity.ok(updateddata);

        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body(e.getMessage());
        }

    }
}
