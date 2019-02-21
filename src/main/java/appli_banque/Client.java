package appli_banque;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

		@Entity
		@Table(name = "client")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "nom", length = 50, nullable = false, unique = true)
	private String nom;
	
	@Column(name = "prenom", length = 50, nullable = false, unique = true)
	private String prenom;
	
	@Column(name = "dateNaissance", nullable = true, unique = true)
	private LocalDate dateNaissance;
	
	@ManyToMany(mappedBy="client")
	private Set<Compte> compte;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="Id_Banque")
		private Banque banque;

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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Compte> getCompte() {
		return compte;
	}

	public void setCompte(Set<Compte> compte) {
		this.compte = compte;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	
	

}
