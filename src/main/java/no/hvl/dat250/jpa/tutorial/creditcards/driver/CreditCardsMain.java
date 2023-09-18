package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;
import java.util.HashSet;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME);
         EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    customer.getAddresses().add(address);

    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10_000);


    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);

    customer.getCreditCards().add(creditCard1);
    customer.getCreditCards().add(creditCard2);

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    creditCard1.setPincode(pincode);
    creditCard2.setPincode(pincode);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    creditCard1.setOwningBank(bank);
    creditCard2.setOwningBank(bank);

    bank.getOwnedCards().add(creditCard1);
    bank.getOwnedCards().add(creditCard2);

    em.persist(customer);
    em.persist(address);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(pincode);
    em.persist(bank);
  }
}
