package com.prectice.hospitalmanagement.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prectice.hospitalmanagement.entity.type.doctorTypes;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String  number;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private doctorTypes doctorType;


    @CreationTimestamp
    private LocalDateTime joining_date;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointment=new ArrayList<>();
}
