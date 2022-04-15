package com.example.integradorV2.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //DNI No se declaró como unique ni se uso como id debido a que existen DNIs repetidos (aunque no deberian existir)
    @Column(nullable = false, name = "dni")
    private Integer DNI;
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
    private List<Appointment> appointments;

}
