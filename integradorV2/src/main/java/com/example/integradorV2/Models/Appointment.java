package com.example.integradorV2.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private Dentist dentist;
    @Column(name = "date_time",nullable = false)
    private LocalDateTime dateTime;



}
