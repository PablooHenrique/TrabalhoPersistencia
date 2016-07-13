package br.com.owl.fabricas;

import br.com.owl.controle.Connection;

public class FabricaConexao {
	
	public Connection getConnection(String collection){
		return new Connection(collection);
	}
}
