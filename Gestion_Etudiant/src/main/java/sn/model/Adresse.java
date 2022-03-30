package sn.model;

public class Adresse {
	private int id;
	private String matricule;
	private String ville;
	private String quartier;
	private String rue;
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(String matricule, String ville, String quartier, String rue) {
		super();
		this.matricule = matricule;
		this.ville = ville;
		this.quartier = quartier;
		this.rue = rue;
	}

	public Adresse(int id, String matricule, String ville, String quartier, String rue) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.ville = ville;
		this.quartier = quartier;
		this.rue = rue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}
	
	
}
