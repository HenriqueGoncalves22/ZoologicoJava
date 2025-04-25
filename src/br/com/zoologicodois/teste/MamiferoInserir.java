package br.com.zoologicodois.teste;

import java.sql.Connection;

import br.com.zoologicodois.beans.Mamifero;
import br.com.zoologicodois.conexao.Conexao;
import br.com.zoologicodois.dao.MamiferoDAO;

public class MamiferoInserir {

	public static void main(String[] args) {

         Connection con = Conexao.abrirConexao();
         
         Mamifero mamifero = new Mamifero();
         MamiferoDAO mamiferodao = new MamiferoDAO(con);
         
         mamifero.setIdade(5);
         mamifero.setMesesGestacao(4);
         mamifero.setNome("Tamanduá");
         
     	System.out.println(mamiferodao.inserir(mamifero));
         Conexao.fecharConexao(con);

	}

}
