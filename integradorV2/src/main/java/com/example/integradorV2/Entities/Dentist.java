package com.example.integradorV2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dentists")
public class Dentist extends User{
    @Column(nullable = false, unique = true,name = "licence_number")
    private Integer licenseNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dentist",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> appointments;


}
