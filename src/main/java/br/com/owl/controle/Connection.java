package br.com.owl.controle;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Connection {
	
	private MongoClient mongoClient;
	private DB db;
	private DBCollection collection;

	public MongoClient getMongoClient() {
		return mongoClient;
	}
	
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	public DB getDb() {
		return db;
	}
	
	public void setDb(DB db) {
		this.db = db;
	}
	
	public DBCollection getCollection() {
		return collection;
	}
	
	public void setCollection(DBCollection collection) {
		this.collection = collection;
	}
	
	public Connection(String col) {
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDB("TrabalhoPersistencia");
		collection = db.getCollection(col);
	}
}
