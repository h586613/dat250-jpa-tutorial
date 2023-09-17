package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;

}
