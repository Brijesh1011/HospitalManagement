package com.prectice.hospitalmanagement.repository;

import com.prectice.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findByName(String name);

    List<Patient> findByBirthdate(LocalDate birthdate);

    boolean existsByEmail(String email);
    boolean existsByContactNumber(String contactNumber);
}
