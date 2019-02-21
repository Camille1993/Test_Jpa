package appli_banque;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class app_banque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();


		//ajoute l'adresse du client	
		Adresse adresseClient = new Adresse();
		adresseClient.setNumero(7);
		adresseClient.setRue("rue des fours à chaux");
		adresseClient.setCodePostal(49530);
		adresseClient.setVille("Bouzillé");

		//ajout de la banque
		Banque banque = new Banque();
		banque.setNom("CreditAgricole");

		//ajout du compte
		AssuranceVie compte = new AssuranceVie();

		compte.setNumero("0081135133511");
		compte.setSolde(1500);
		
		Set<Compte> comptes = new HashSet<Compte>();
		comptes.add(compte);
		compte.setDateFin(LocalDate.of(2020, 12, 31));
		compte.setTaux(2.36);
		
		Livret_A compte2 = new Livret_A();
		compte2.setNumero("06235383548");
		compte2.setSolde(1460);
		comptes.add(compte2);
		compte2.setTaux(2.51);
		
		
		//ajout de l'opération
		Virement operation = new Virement();
		operation.setDate(LocalDateTime.now());
		operation.setMontant(666);
		operation.setMotif("retrait");
		operation.setCompte(compte);
		operation.setCompte(compte2);
		Set<Operation> operations = new HashSet<Operation>();
		operations.add(operation);
		operation.setBeneficiaire("");
		
		operation.setCompte(compte2);

		//ajout du client
		Client client = new Client();
		client.setNom("Hautois");
		client.setPrenom("Camille");
		client.setDateNaissance(LocalDate.of(1993, 12, 15));

		client.setAdresse(adresseClient);
		client.setBanque(banque);
		client.setCompte(comptes);
		Set<Client> clients = new HashSet<Client>();
		clients.add(client);

		//ajout du client dans la banque
		banque.setClient(clients);

		//ajout des operation et du client au compte
		compte.setClient(clients);
		compte2.setClient(clients);
		compte.setOperations(operations);
		compte2.setOperations(operations);

		//transaction obligatoire avec les persistances	
		transaction.begin();
		em.persist(client);
		em.persist(banque);
		em.persist(compte);
		em.persist(compte2);
		em.persist(operation);
		transaction.commit();
		em.close();






	}
}
