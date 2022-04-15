package com.example.integradorV2.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Integer licenseNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dentist",fetch = FetchType.LAZY)
    private List<Appointment> appointments;
}
