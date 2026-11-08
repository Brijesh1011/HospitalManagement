package com.prectice.hospitalmanagement.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prectice.hospitalmanagement.entity.type.BloodGroupType;
import com.prectice.hospitalmanagement.entity.type.GenderType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDate birthdate;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @Column(unique = true,nullable = false)
    private String contactNumber;

    @CreationTimestamp
    private LocalDateTime createAt;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<PatientHistory> histories = new ArrayList<>();
}