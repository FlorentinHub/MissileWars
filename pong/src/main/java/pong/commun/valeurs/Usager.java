package pong.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Usager implements ModelValue {
	
	private String id;
	private String prenom;
	private String nom;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Usager() {
	}

	public Usager(String id, String prenom, String nom) {
		setId(id);
		setPrenom(prenom);
		setNom(nom);
	}

	@Override
	public String toString() {
		return nomComplet();
	}
	
	public String nomComplet() {
		return prenom + " " + nom;
	}
	
	@Override
	public boolean equals(Object autre) {
		boolean siEgal = false;
		
		if(autre == this) {

			siEgal = true;

		}else if(autre instanceof Usager) {
			
			siEgal = siEgal((Usager) autre);

		}

		return siEgal;
	}
	
	private boolean siEgal(Usager autre) {
		return siMemeIdQue(autre)
				&& siMemePrenomQue(autre)
				&& siMemeNomQue(autre);
	}
	
	private boolean siMemeIdQue(Usager autre) {
		boolean siMemeId = false;
		
		if(id == null && autre.id == null) {
			
			siMemeId = true;

		}else if(id != null) {
			
			siMemeId = id.equals(autre.id);

		}
		
		return siMemeId;
	}

	private boolean siMemePrenomQue(Usager autre) {
		boolean siMemePrenom = false;
		
		if(prenom == null && autre.prenom == null) {
			
			siMemePrenom = true;

		}else if(prenom != null) {
			
			siMemePrenom = prenom.equals(autre.prenom);

		}
		
		return siMemePrenom;
	}

	private boolean siMemeNomQue(Usager autre) {
		boolean siMemeNom = false;
		
		if(nom == null && autre.nom == null) {
			
			siMemeNom = true;

		}else if(nom != null) {
			
			siMemeNom = nom.equals(autre.nom);

		}
		
		return siMemeNom;
	}

}
