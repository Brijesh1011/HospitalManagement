package com.prectice.hospitalmanagement.controllers;

import com.prectice.hospitalmanagement.dto.PatientHistoryRequestDTO;
import com.prectice.hospitalmanagement.dto.PatientHistoryResponseDTO;
import com.prectice.hospitalmanagement.entity.Doctor;
import com.prectice.hospitalmanagement.entity.PatientHistory;
import com.prectice.hospitalmanagement.service.PatientHistoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patienthistory")
public class PatientHistoryController {

    private final PatientHistoryService patientHistoryService;


    // Get all history
    @GetMapping
    public ResponseEntity<List<PatientHistoryResponseDTO>> getAllHistory(){

        List<PatientHistoryResponseDTO> response = patientHistoryService.get_all_patient_History()
                .stream()
                .map(PatientHistoryResponseDTO::fromEntity)
                .toList();


        return ResponseEntity.ok(response);
    }

    @GetMapping("/patient/{patientId}")
    public  ResponseEntity<List<PatientHistoryResponseDTO>> getPatientHistoryById(@PathVariable Long patientId){

        List<PatientHistoryResponseDTO> response = patientHistoryService.get_Patient_History_By_Id(patientId)
                .stream()
                .map(PatientHistoryResponseDTO::fromEntity)
                .toList();


        return ResponseEntity.ok(response);
    }




    @PostMapping("/patient/Add/{patientId}")
    public ResponseEntity<?> Add_Patient_History(@PathVariable Long patientId,@RequestBody PatientHistoryRequestDTO request){

        try{

            PatientHistory savedHistory =
                    patientHistoryService.createHistory(patientId, request);

            PatientHistoryResponseDTO response =
                    PatientHistoryResponseDTO.fromEntity(savedHistory);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);

        } catch (RuntimeException e) {
            return  ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(e.getMessage());
        }

    }


}
