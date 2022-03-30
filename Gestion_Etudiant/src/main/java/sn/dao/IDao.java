package sn.dao;

import java.util.List;

public interface IDao <T> {
	public void save(T t);
	public List<T> liste();
	public List<T> listByMatricule(String matricule);
	public void edit(T t);
	public void delete(int id);
}
