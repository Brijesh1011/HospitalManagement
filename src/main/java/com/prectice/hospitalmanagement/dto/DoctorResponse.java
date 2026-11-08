package com.prectice.hospitalmanagement.dto;

import com.prectice.hospitalmanagement.entity.type.doctorTypes;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class DoctorResponse {

    private Long id;
    private String name;
    private String number;
    private String email;
    private doctorTypes doctorType;
    private LocalDateTime joining_date;

}

