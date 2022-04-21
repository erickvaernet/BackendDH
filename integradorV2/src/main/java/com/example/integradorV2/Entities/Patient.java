package com.example.integradorV2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //DNI No se declaró como unique ni se uso como id debido a que existen DNIs repetidos (aunque no deberian existir)
    @Column(nullable = false, name = "dni")
    private Integer dni;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,name = "last_name")
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, name = "entry_date")
    private LocalDate entryDate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id",referencedColumnName = "id", nullable = false)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> appointments;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && dni.equals(patient.dni) && name.equals(patient.name) && lastName.equals(patient.lastName) && email.equals(patient.email) && entryDate.equals(patient.entryDate) && address.equals(patient.address) && Objects.equals(appointments, patient.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, name, lastName, email, entryDate, address, appointments);
    }
}
