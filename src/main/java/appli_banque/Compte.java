package appli_banque;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;

	@Column(name = "numero", length = 50, nullable = false, unique = true)
	private String numero;

	@Column(name = "solde", length = 50, nullable = false, unique = true)
	private double solde;

	@ManyToMany
	@JoinTable(name="compte_client",
	joinColumns=@JoinColumn(name="numero_compteClient", referencedColumnName="numero"),
	inverseJoinColumns=@JoinColumn(name="nom_client", referencedColumnName="nom")
			)
	private Set<Client>client;

	@OneToMany(mappedBy="compte")
	private Set<Operation>operations;



	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}



}
