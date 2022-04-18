package com.example.integradorV2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true,name = "licence_number")
    private Integer licenseNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dentist",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> appointments;
}
