import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class TestJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();

		Livre livre = em.find(Livre.class,1);
		if (livre != null){
			System.out.println("L'ID du livre est " + livre.getId() + ", son nom est : " + livre.getTitre() + " écrit par " + livre.getAuteur());
		}

		Query query = em.createQuery("select livre from Livre livre where livre.titre='Germinal'");
		Livre livre1 = (Livre) query.getResultList().get(0);
		if (livre1 != null){
			System.out.println("L'ID du livre est " + livre1.getId() + ", son nom est : " + livre1.getTitre() + " écrit par " + livre1.getAuteur());
		}

		TypedQuery<Livre> query2 = em.createQuery("select livre from Livre livre where livre.titre ='Guerre et paix'", Livre.class);
		Livre livre2 = query2.getResultList().get(0);
		if (livre2 != null){
			System.out.println("L'ID du livre est " + livre2.getId() + ", son nom est : " + livre2.getTitre() + " écrit par " + livre2.getAuteur());
		} 


		// realiser requete qui permet d'extraire un emprunt et tous ses livres associes

		TypedQuery<Emprunt> query3 = em.createQuery("Select emprunt from Emprunt emprunt where emprunt.Id='2'", Emprunt.class);
		Emprunt emprunt1 = query3.getSingleResult();

		for(Livre L: emprunt1.getLivres()){
			if(L.getId() != null){
				System.out.println(L.getTitre());
			}
		}

		TypedQuery<Clients> query4 = em.createQuery("Select client from Clients client where client.Id='2'", Clients.class);
		Clients client = query4.getSingleResult();
		System.out.println(client.getEmprunts().size());
		for(Emprunt E: client.getEmprunts()){
			if(E.getId() != null){
				for(Livre L: E.getLivres()){
					System.out.println(L.getTitre());

				}
			}

		}
	}


}



