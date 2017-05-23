package it.uniroma2.fase6.configuration;


import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
class MongoConfiguration extends AbstractMongoConfiguration {

	protected String user = "gqms_user56";
	protected String password = "M8NtUa1g";
	protected String database = "gqms_6internal";
	protected Integer port = 27017;
//	protected String host = "qips.sweng.uniroma2.it";
	protected String host = "qips-test.sweng.uniroma2.it";
	
//	protected String user = null;
//	protected String password = null;
//	protected String database = "fase6dev";
//	protected Integer port = 27017;
//	protected String host = "127.0.0.1";

	@Override
	protected String getDatabaseName() {
		return database;
	}

	@Override
	public Mongo mongo() throws Exception {
		// return new Mongo();
		return new MongoClient();
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		
		MongoClient mongoClient = null;
		ServerAddress serverAddress = new ServerAddress(host,port);
		
		
		if(user!=null){
		// Set credentials
		MongoCredential credential = MongoCredential.createCredential(user, getDatabaseName(), password.toCharArray());

		// Mongo Client
		mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
		
		}else{
			
		
		mongoClient = new MongoClient(serverAddress);
			
		}
		
		// Mongo DB Factory
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, getDatabaseName());
		
		
		return simpleMongoDbFactory;

	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		
		return mongoTemplate;
	}

}
