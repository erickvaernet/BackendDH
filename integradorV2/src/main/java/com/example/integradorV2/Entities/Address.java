package com.example.integradorV2.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private Integer number;
    @Column(nullable = true)
    private String city;
    @Column(nullable = true)
    private String state;

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && street.equals(address.street) && number.equals(address.number) && Objects.equals(city, address.city) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, number, city, state);
    }
}
