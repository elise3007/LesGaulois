package personnages;

import objets.Equipement;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
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
	
	
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0;
//		int ancienneForce = force;
//		this.force = force - forceCoup;
//		if (force < 1) {
//			this.parler("J'abandonne !");
//		} else {
//			this.parler("Aïe");
//		}
//		assert ancienneForce >= force;
//		assert isInvariantVerified(force);
//	}
	
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0){
			parler("Aïe");
		} else{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}
	
	
	private int calculerResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 6;
				} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 3;
				}
			}
		}
		
		if (resistanceEquipement <= forceCoup) {
			forceCoup -= resistanceEquipement;
			texte += "\nMais heureusement, grace à mon équipement sa force est diminuée de " + resistanceEquipement + "!";
		} else {
			forceCoup = 0;
			texte += "\nMais heureusement grâce à mon équipement sa force a été complètement absorbée.";
		}
		parler(texte);
		return forceCoup;
	}
	
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
		}
	
	
	public int getForce() {
		return force;
	}


	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2 :
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1 :
				if (this.equipements[0] == equipement) {
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
		this.equipements[nbEquipement] = equipement;
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
