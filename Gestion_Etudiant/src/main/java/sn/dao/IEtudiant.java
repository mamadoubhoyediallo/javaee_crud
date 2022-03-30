package sn.dao;

import java.util.List;

import sn.model.Etudiant;

public interface IEtudiant extends IDao<Etudiant> {
	public List<Etudiant> findAll();
	public Etudiant getEtudiant(int id);
}

