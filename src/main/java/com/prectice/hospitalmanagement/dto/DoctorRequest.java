package com.prectice.hospitalmanagement.dto;


import com.prectice.hospitalmanagement.entity.type.doctorTypes;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorRequest {

    private String name;
    private String number;
    private String email;
    private doctorTypes doctorType;
}
