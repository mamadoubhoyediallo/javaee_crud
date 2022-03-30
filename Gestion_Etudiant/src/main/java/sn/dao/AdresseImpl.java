package sn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.model.Adresse;

public class AdresseImpl implements IAdresse {
	Connection con = Db.getConnection();
	@Override
	public void save(Adresse a) {
		String sql = "INSERT INTO adresse VALUES(NULL, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getMatricule());
			ps.setString(2, a.getVille());
			ps.setString(3, a.getQuartier());
			ps.setString(4, a.getRue());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Adresse> liste() {
		String sql = "SELECT * FROM adresse";
		List<Adresse> liste = new ArrayList<Adresse>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Adresse a = new Adresse();
				a.setId(rs.getInt(1));
				a.setMatricule(rs.getString(2));
				a.setVille(rs.getString(3));
				a.setQuartier(rs.getString(4));
				a.setRue(rs.getString(5));
				liste.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public List<Adresse> listByMatricule(String matricule) {
		List<Adresse> la = new ArrayList<Adresse>();
		String sql = "SELECT * FROM adresse WHERE matricule LIKE ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+matricule+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Adresse a = new Adresse();
				a.setId(rs.getInt("id"));
				a.setMatricule(rs.getString("matricule"));
				a.setVille(rs.getString("ville"));
				a.setQuartier(rs.getString("quartier"));
				a.setRue(rs.getString("rue"));
				la.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return la;
	}

	@Override
	public void edit(Adresse a) {
		String sql = "UPDATE adresse SET matricule = ?, ville = ?, quartier = ?, rue = ? WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getMatricule());
			ps.setString(2, a.getVille());
			ps.setString(3, a.getQuartier());
			ps.setString(4, a.getRue());
			ps.setInt(5, a.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM adresse WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Adresse getAdresse(int id) {
		String sql = "SELECT * FROM adresse WHERE id = ?";
		Adresse ad = new Adresse();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ad.setId(rs.getInt("id"));
				ad.setMatricule(rs.getString("matricule"));
				ad.setVille(rs.getString("ville"));
				ad.setQuartier(rs.getString("quartier"));
				ad.setRue(rs.getString("rue"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ad;
	}

	@Override
	public List<Adresse> listeE() {
		String sql = "SELECT quartier FROM adresse";
		List<Adresse> liste = new ArrayList<Adresse>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Adresse a = new Adresse();				
				a.setQuartier(rs.getString("quartier"));
				liste.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}

}
