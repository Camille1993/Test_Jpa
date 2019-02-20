import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TestJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		/*Livre livre = em.find(Livre.class,1);
		if (livre != null){
			System.out.println("L'ID du livre est " + livre.getId() + ", son nom est : " + livre.getTitre() + " écrit par " + livre.getAuteur());
		}*/
		
		Query query = em.createQuery("select livre from Livre livre where livre.titre='Vingt mille lieues sous les mers'");
		Livre livre1 = (Livre) query.getResultList().get(0);
		if (livre1 != null){
			System.out.println("L'ID du livre est " + livre1.getId() + ", son nom est : " + livre1.getTitre() + " écrit par " + livre1.getAuteur());
		}
		
		
	}
	
}

