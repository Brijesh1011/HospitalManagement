package com.prectice.hospitalmanagement.repository;

import com.prectice.hospitalmanagement.entity.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

    List<PatientHistory> findByPatient_Id(Long patientId);

}
