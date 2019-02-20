import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "livre") 
public class Livre {
		@Id
		private Integer Id;
		@Column(name = "TITRE", length = 255, nullable = false, unique = true )
		private String titre;
		@Column(name = "AUTEUR", length = 50, nullable = false, unique = true )
		private String auteur;
		
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getAuteur() {
			return auteur;
		}
		public void setAuteur(String auteur) {
			this.auteur = auteur;
		}
		
		
	}
	
		



