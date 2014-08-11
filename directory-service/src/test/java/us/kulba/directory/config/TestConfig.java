package us.kulba.directory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import us.kulba.directory.dao.ContactRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = ContactRepository.class)
public class TestConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        String mongoDbHost = "localhost";
        int mongoDbPort = 27017;
        Mongo mongo = new Mongo(mongoDbHost, mongoDbPort);
        String databaseName = "directory";
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }

}
