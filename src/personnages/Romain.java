package personnages;

import objets.Equipement;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;
	
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
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2 :
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1 :
				if (this.equipement[0] == equipement) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
				} else {
					ajouterEquipement(equipement);
				}
				break;
			default:
				ajouterEquipement(equipement);
				break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		this.equipement[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + " !");
	}
	
	private boolean isInvariantVerified(int forceRomain) {
		return forceRomain >= 0;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
