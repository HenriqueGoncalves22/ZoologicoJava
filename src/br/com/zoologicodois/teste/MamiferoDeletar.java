package br.com.zoologicodois.teste;

import java.sql.Connection;

import br.com.zoologicodois.beans.Mamifero;
import br.com.zoologicodois.conexao.Conexao;
import br.com.zoologicodois.dao.MamiferoDAO;

public class MamiferoDeletar {

	public static void main(String[] args) {

         Connection con = Conexao.abrirConexao();
         
         Mamifero mamifero = new Mamifero();
         MamiferoDAO mamiferodao = new MamiferoDAO(con);

         mamifero.setNome("Cachorro");
         
     	 System.out.println(mamiferodao.deletar(mamifero));
         Conexao.fecharConexao(con);

	}

}
