package br.com.zoologicodois.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.zoologicodois.beans.Mamifero;

public class MamiferoDAO {

	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public MamiferoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Mamifero mamifero) {
		String sql = "insert into mamifero(nome, idade, mesesgestacao) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, mamifero.getNome());
			ps.setInt(2, mamifero.getIdade());
			ps.setInt(3, mamifero.getMesesGestacao());
			
			if(ps.executeUpdate() > 0)
				return "Sucesso!";
			else
				return "Falha";
		}
		catch(SQLException e)
		{
			return e.getMessage();
		}
	}
}
