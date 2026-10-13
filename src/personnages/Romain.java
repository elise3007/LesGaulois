package personnages;

public class Romain {

	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
 	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int ancienneForce = force;
		this.force = force - forceCoup;
		assert isInvariantVerified(force);
		if (force < 1) {
			this.parler("J'abandonne !");
		} else {
			this.parler("Aïe");
		}
		assert ancienneForce >= force;
	}
	
	private boolean isInvariantVerified(int forceRomain) {
		return forceRomain >= 0;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", -6);
	}
}
