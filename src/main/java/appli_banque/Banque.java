package appli_banque;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

		@Entity
		@Table(name = "banque")
public class Banque implements Serializable  {
			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			private Integer Id;
			
			@Column(name = "nom", length = 50, nullable = false, unique = true)
			private String nom;
			
			@OneToMany(mappedBy="banque")
			private Set<Client> client;

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

			public Set<Client> getClient() {
				return client;
			}

			public void setClient(Set<Client> client) {
				this.client = client;
			}
			

}
