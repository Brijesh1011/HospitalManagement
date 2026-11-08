package com.prectice.hospitalmanagement.dto;


import com.prectice.hospitalmanagement.entity.type.BloodGroupType;
import com.prectice.hospitalmanagement.entity.type.GenderType;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PatientRequest {


        private String name;

        private LocalDate birthdate;

        private String email;

        private GenderType gender;

        private BloodGroupType bloodGroup;

        private String contactNumber;

}
