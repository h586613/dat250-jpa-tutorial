package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

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
    // TODO: Create object world as shown in the README.md.   "expass2.md"*?
    //Customer customer = new Customer("Max Mustermann");
    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    Address address = new Address("Inndalsveien", 28);
    CreditCard creditCard1 = new CreditCard(12345,5000,10000);
    CreditCard creditCard2 = new CreditCard(123,1,2000);
    Pincode pincode = new Pincode("123",1);
    Bank bank = new Bank("Pengebank");

    em.persist(customer);
    em.persist(address);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(pincode);
    em.persist(bank);
  }
}
