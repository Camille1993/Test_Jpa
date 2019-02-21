package appli_banque;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	@Column(name = "date", nullable = false, unique = true)
	private LocalDateTime date;

	@Column(name = "montant", nullable = false, unique = true)
	private double montant;

	@Column(name = "motif", length = 75, nullable = false, unique = true)
	private String motif;

	@ManyToOne
	@JoinColumn(name = "Id_compte")
	private Compte compte;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
