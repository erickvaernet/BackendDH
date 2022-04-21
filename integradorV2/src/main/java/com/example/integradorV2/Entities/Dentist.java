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
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dentist dentist = (Dentist) o;
        return Objects.equals(id, dentist.id) && licenseNumber.equals(dentist.licenseNumber) && name.equals(dentist.name) && lastName.equals(dentist.lastName) && Objects.equals(appointments, dentist.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licenseNumber, name, lastName, appointments);
    }
}
