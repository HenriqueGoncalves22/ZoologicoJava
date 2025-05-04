package br.com.zoologicodois.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				return "Sucesso ao adicionar mamifero!";
			else
				return "Falha o adicionar mamifero!";
		}
		catch(SQLException e)
		{
			return e.getMessage();
		}
	}
	
	public String deletar(Mamifero mamifero) {
		String sql = "delete from mamifero where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  mamifero.getNome());
			if (ps.executeUpdate() > 0) {
				return "Mamifero excluído com sucesso";
			} else {
				return "Erro ao excluir mamifero";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Mamifero mamifero) {
		String sql = "update mamifero set idade = ? where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1,  mamifero.getIdade());
			ps.setString(2,  mamifero.getNome());
			if (ps.executeUpdate() > 0) {
				return "Idade atualizada com sucesso";
			} else {
				return "Erro ao atualizar a Idade";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public ArrayList<Mamifero> retornarDados()
	{
		String sql = "select * from mamifero";
		ArrayList<Mamifero> retornarMamifero = new ArrayList<Mamifero>();
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Mamifero mamifero = new Mamifero();
					mamifero.setNome(rs.getString(1));
					mamifero.setIdade(rs.getInt(2));
					mamifero.setMesesGestacao(rs.getInt(3));
				retornarMamifero.add(mamifero);
				}
				return retornarMamifero;
				}
			else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
		
	}
}
