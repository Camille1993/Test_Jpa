import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;	
	
		@Entity
		@Table(name = "emprunt")

public class Emprunt {
			@Id
			private Integer Id;
			
			@Column(name = "DATE_DEBUT", nullable = false, unique = true)
			private LocalDate dateDebut;
			
			@Column(name = "DATE_FIN", nullable = true, unique = true)
			private LocalDate dateFin;
			
			@Column(name = "DELAI", nullable = true, unique = true)
			private int delai;
			
			
			@ManyToMany
				@JoinTable(name = "COMPO",
					joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
					inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
				)
			private Set<Livre> livres;
			
			@ManyToOne
			@JoinColumn(name="ID_CLIENT")
			private Clients client;

			public Integer getId() {
				return Id;
			}

			public void setId(Integer id) {
				Id = id;
			}

			public LocalDate getDateDebut() {
				return dateDebut;
			}

			public void setDateDebut(LocalDate dateDebut) {
				this.dateDebut = dateDebut;
			}

			public LocalDate getDateFin() {
				return dateFin;
			}

			public void setDateFin(LocalDate dateFin) {
				this.dateFin = dateFin;
			}

			public int getDelai() {
				return delai;
			}

			public void setDelai(int delai) {
				this.delai = delai;
			}

			public Set<Livre> getLivres() {
				return livres;
			}

			public void setLivres(Set<Livre> livres) {
				this.livres = livres;
			}

			public Clients getClient() {
				return client;
			}

			public void setClient(Clients client) {
				this.client = client;
			}
}
