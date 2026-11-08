package com.prectice.hospitalmanagement.dto;

import com.prectice.hospitalmanagement.entity.type.BloodGroupType;
import com.prectice.hospitalmanagement.entity.type.GenderType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PatientResponse {

    private Long id;

    private String name;

    private LocalDate birthdate;

    private String email;

    private GenderType gender;

    private BloodGroupType bloodGroup;

    private String contactNumber;

    private LocalDateTime createAt;
}
