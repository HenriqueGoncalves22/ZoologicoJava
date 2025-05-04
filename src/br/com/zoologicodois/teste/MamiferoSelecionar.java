package br.com.zoologicodois.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.zoologicodois.beans.Mamifero;
import br.com.zoologicodois.conexao.Conexao;
import br.com.zoologicodois.dao.MamiferoDAO;

public class MamiferoSelecionar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Connection con = Conexao.abrirConexao();
         
         MamiferoDAO mamiferodao = new MamiferoDAO(con);
         
         ArrayList<Mamifero> lista = mamiferodao.retornarDados();
         
         if(lista != null) {
        	 for(Mamifero mamifero: lista) {
        		 System.out.println("Nome: " + mamifero.getNome() + " | " +
        	  "Idade: " + mamifero.getIdade() + " | " + "Meses de Gestação" +
        				 mamifero.getIdade());
        	 }
         }
         Conexao.fecharConexao(con);
	}

}
