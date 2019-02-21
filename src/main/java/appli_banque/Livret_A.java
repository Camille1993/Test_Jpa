package appli_banque;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livretA")
public class Livret_A extends Compte{
	
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	}

