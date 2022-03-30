package sn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.model.Adresse;
//import sn.model.Adresse;
import sn.model.Etudiant;

public class EtudiantImpl implements IEtudiant {
	Connection con = Db.getConnection();
	@Override
	public void save(Etudiant e) {
		String sql = "INSERT INTO etudiant VALUES(NULL, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getMatricule());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getPrenom());
			ps.setInt(4, e.getTelephone());
			ps.setInt(5, e.getAdresse().getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	@Override
	public List<Etudiant> liste() {
		String sql = "SELECT e.id, e.matricule, e.nom, e.prenom, e.telephone, a.id FROM etudiant e INNER JOIN adresse a ON e.idA = a.id";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				//Adresse a = new Adresse();
				e.setId(rs.getInt(1));
				e.setMatricule(rs.getString(2));
				e.setNom(rs.getString(3));
				e.setPrenom(rs.getString(4));
				e.setTelephone(rs.getInt(5));
				e.getAdresse().setId(rs.getInt(6));
				liste.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public List<Etudiant> listByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Etudiant e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Etudiant> findAll() {
		String sql = "SELECT * from etudiant ";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				//Adresse a = new Adresse();
				e.setId(rs.getInt(1));
				e.setMatricule(rs.getString(2));
				e.setNom(rs.getString(3));
				e.setPrenom(rs.getString(4));
				e.setTelephone(rs.getInt(5));
				e.getAdresse().setId(rs.getInt(6));
				liste.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public Etudiant getEtudiant(int id) {
		String sql = "SELECT * FROM etudiant WHERE id = ?";
		Etudiant etudiant = new Etudiant();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				etudiant.setId(rs.getInt(1));
				etudiant.setMatricule(rs.getString(2));
				etudiant.setNom(rs.getString(3));
				etudiant.setPrenom(rs.getString(4));
				etudiant.setTelephone(rs.getInt(5));
				etudiant.getAdresse().setId(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etudiant;
	}

}
