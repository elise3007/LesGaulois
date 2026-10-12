package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = 1;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}
	
	private String prendreParole() {
		return "Le gaulois" + nom + " : ";
		
	}
	
	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
		int forceCoup = force * effetPotion/ 3;
		romain.recevoirCoup(forceCoup);
		if (effetPotion > 1) {
			effetPotion = effetPotion - 1;
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

	@Override
	public String toString() {
		return nom;
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
	

}
