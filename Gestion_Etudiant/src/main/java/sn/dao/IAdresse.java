package sn.dao;


import java.util.List;

import sn.model.Adresse;

public interface IAdresse extends IDao<Adresse>{
	public Adresse getAdresse(int id);
	public List<Adresse> listeE();
}
