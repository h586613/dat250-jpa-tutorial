package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses;

    @ManyToMany
    private List<CreditCard> creditCards;

}
