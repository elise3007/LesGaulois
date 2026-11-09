package village_gaulois;

import objets.Trophee;
import personnages.Gaulois;
import objets.Equipement;

public class Musee {

	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < 200) {
			Trophee trophee = new Trophee(gaulois, equipement);
			trophees[nbTrophee] = trophee;
			nbTrophee++;
			System.out.println("Le trophée a été ajouté !");
		} else {
			System.out.println("Le musée est plein, le trophée n'a pas pu être ajouté !");
		}
	}
	
	public String extraireInstructionsOCaml() {
		String instructions	= "let musee = [";
		for (int i = 0 ; i < nbTrophee ; i++) {
			String gaulois = trophees[i].donnerNom();
			Equipement equipement = trophees[i].getEquipement();
			String nomEquipement = equipement.toString();
			instructions += "\n    " + "\"" + gaulois + "\"" + ", " + "\"" + nomEquipement + "\"";
			if (i < nbTrophee - 1) {
				instructions += ";";
			}
		}
		
		instructions += "\n]";
		return instructions;
	}
}
