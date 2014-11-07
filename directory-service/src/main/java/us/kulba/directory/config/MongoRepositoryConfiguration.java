package us.kulba.directory.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import us.kulba.directory.dao.ContactRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = { ContactRepository.class })
public class MongoRepositoryConfiguration {

    public
    @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
//        UserCredentials userCredentials = new UserCredentials("joe", "secret");
        return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "directory");
    }

    public
    @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
