import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;


	@Entity
	@Table(name = "client")

public class Clients {
		@Id
		private Integer Id;
		
		@Column(name = "NOM", length = 50, nullable = false, unique = true)
		private String nom;
		
		@Column(name = "PRENOM", length = 50, nullable = false, unique = true)
		private String prenom;
		
		@OneToMany(mappedBy="client")
		private Set<Emprunt> emprunts;

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public Set<Emprunt> getEmprunts() {
			return emprunts;
		}

		public void setEmprunts(Set<Emprunt> emprunts) {
			this.emprunts = emprunts;
		}
	
		
	//getter et setter pour clients
		
		
}
