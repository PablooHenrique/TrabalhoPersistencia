package br.com.owl.controle;


import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import br.ufg.inf.es.saep.sandbox.dominio.Tipo;

/**
 * @author pablo.carvalho
 *
 *Classe incial para validacao previa dos metodos. 
 *Sera mudada para classes de testes na proxima versao do trabalho
 *
 */
public class Start {

	public static void main(String[] args) {
		
//		String tipo = "	{"+
//				  "'id': 12,"+
//				  "'nome': 'Regime Graduacao Semestral',"+
//				  "'descricao': 'Aulas Para Os alunos',"+
//				  "'atributos': {"+
//				  "		'LOGICO': 0,"+
//				  "		'REAL': 1,"+
//				  "		'STRING': 2,"+
//				  "		'nome': 'Identificador do Atributo',"+
//				  "		'tipo': 1,"+
//				  "		'descricao': 'Descricao'"+
//				  "		}"+
//				  "}";
		
		String tipo = "{"+
			 " 'id': 10,"+
			 " 'nome': 'Regime Graduacao Semestral',"+
			 " 'descricao': 'Aulas Para Os alunos',"+
			 " 'atributos': [{"+
			  "  'LOGICO': 0,"+
			  "  'REAL': 1,"+
			  "  'STRING': 2,"+
			  "  'nome': 'Identificador do Atributo',"+
			  "  'tipo': 1,"+
			 "   'descricao': 'Descricao'"+
			 " },"+
			 " {"+
			   " 'LOGICO': 0,"+
			   " 'REAL': 1,"+
			   " 'STRING': 2,"+
			   " 'nome': 'Identificador do Atributo',"+
			   " 'tipo': 1,"+
			   " 'descricao': 'Descricao'"+
			  "}"+
			  "]"+
			"}";
		
		
		
		
//		
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		DB db = mongoClient.getDB("exemplo");
//		DBObject dbObject = (DBObject) new JSON().parse(tipo);
//		DBCollection collection = db.getCollection("AvaliacaoDocente");
//		collection.insert(dbObject);
//		
//		DBCursor cursor = collection.find();
//        while(cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//        
//        WriteResult result = collection.remove(new BasicDBObject("id", 10));
//        System.out.println(result.toString());
//        
//        DBCursor cursor = collection.find();
//        while(cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
		
//		ResolucaoRepository resolucao = new ResolucaoRepositoryImpl();
//		resolucao.removeTipo("11");
//		resolucao.tipoPeloCodigo("12");
		
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		DB db = mongoClient.getDB("exemplo");
//		DBCollection collection = db.getCollection("AvaliacaoDocente");
//		DBCursor cursor = collection.find(new BasicDBObject("id", 10));
//        while(cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
		
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exemplo");
		DBCollection collection = db.getCollection("AvaliacaoDocente");
		DBCursor cursor = collection.find(new BasicDBObject("id", 10));
		
		List<Tipo> list = new Gson().fromJson(cursor.next().toString(), new TypeToken<List<Tipo>>(){}.getType());
				
		while (cursor.hasNext()) {
			Object object = cursor.next().get("atributos");
			
			System.out.println(object.toString());
		}

		
	}
}

