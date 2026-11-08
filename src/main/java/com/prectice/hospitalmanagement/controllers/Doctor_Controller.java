package com.prectice.hospitalmanagement.controllers;


import com.prectice.hospitalmanagement.dto.DoctorRequest;
import com.prectice.hospitalmanagement.dto.DoctorResponse;
import com.prectice.hospitalmanagement.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@AllArgsConstructor
public class Doctor_Controller {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<?> All_Doctor(){

        try{
            List<DoctorResponse> all_Doc=doctorService.All_Doctor();
            return ResponseEntity.ok(all_Doc);
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

    @PostMapping("/add_doctor")
    public ResponseEntity<?> Add_Doctor(@RequestBody DoctorRequest request){
    try{
        DoctorResponse SavedDoctor=doctorService.addDoctor(request);
        return  ResponseEntity.ok(SavedDoctor);

    } catch (RuntimeException e) {
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> Doctor_by_id(@PathVariable Long id){

        try{

            DoctorResponse doctor=doctorService.Doctor_by_id(id);
            return ResponseEntity.ok(doctor);

        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete_by_id(@PathVariable Long id){
        doctorService.Delete_by_id(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> Upadate_by_id(@PathVariable Long id,@RequestBody DoctorRequest request){
        try{
            DoctorResponse updatedDoctor= doctorService.Upadate_by_id(id, request);

            return ResponseEntity.ok(updatedDoctor);

        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

}
