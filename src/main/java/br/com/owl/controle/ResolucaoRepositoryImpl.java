package br.com.owl.controle;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

import br.com.owl.fabricas.FabricaConexao;
import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import br.ufg.inf.es.saep.sandbox.dominio.ResolucaoRepository;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;

public class ResolucaoRepositoryImpl implements ResolucaoRepository{
	
	
	public ResolucaoRepositoryImpl() {
		
	}
	
	public Resolucao byId(String id) {
		DBCollection collection = new FabricaConexao().getConnection("resolucao").getCollection();
		int codigoInt = Integer.parseInt(id);
		DBCursor cursor = collection.find(new BasicDBObject("id", codigoInt));
		while (cursor.hasNext()) {
			return new Gson().fromJson(cursor.next().toString(), Resolucao.class);
		}
		return null;
	}

	public String persiste(Resolucao resolucao) {
		DBCollection collection = new FabricaConexao().getConnection("resolucao").getCollection();
		DBObject dbObject = (DBObject) new JSON().parse(new Gson().toJson(resolucao));
		collection.insert(dbObject);
		return null;
	}

	public boolean remove(String identificador) {
		DBCollection collection = new FabricaConexao().getConnection("resolucao").getCollection();
		int codigoInt = Integer.parseInt(identificador);
		collection.remove(new BasicDBObject("id", codigoInt));
		return false;
	}

	public List<String> resolucoes() {
		DBCollection collection = new FabricaConexao().getConnection("resolucao").getCollection();
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			return new Gson().fromJson(cursor.next().toString(), new TypeToken<List<Tipo>>(){}.getType());
		}
		return null;
	}

	public void persisteTipo(Tipo tipo) {
		DBCollection collection = new FabricaConexao().getConnection("tipo").getCollection();
		DBObject dbObject = (DBObject) new JSON().parse(new Gson().toJson(tipo));
		collection.insert(dbObject);
	}

	public void removeTipo(String codigo) {
		DBCollection collection = new FabricaConexao().getConnection("tipo").getCollection();
		int codigoInt = Integer.parseInt(codigo);
		collection.remove(new BasicDBObject("id", codigoInt));
	}

	public Tipo tipoPeloCodigo(String codigo) {
		DBCollection collection = new FabricaConexao().getConnection("tipo").getCollection();
		int codigoInt = Integer.parseInt(codigo);
		DBCursor cursor = collection.find(new BasicDBObject("id", codigoInt));
		while (cursor.hasNext()) {
			return new Gson().fromJson(cursor.next().toString(), Tipo.class);
		}
		return null;
	}

	public List<Tipo> tiposPeloNome(String nome) {
		DBCollection collection = new FabricaConexao().getConnection("tipo").getCollection();
		DBCursor cursor = collection.find(new BasicDBObject("nome", nome));
		while (cursor.hasNext()) {
			return new Gson().fromJson(cursor.next().toString(), new TypeToken<List<Tipo>>(){}.getType());
		}
		return null;
	}
}
