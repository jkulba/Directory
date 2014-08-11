package us.kulba.directory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
import us.kulba.directory.model.Contact;

import java.util.List;

/**
 * ContactRepository is a Spring Data MongoRepository managing Contacts.
 */
public interface ContactRepository extends MongoRepository<Contact, String> {

    List<Contact> findByLastNameLike(String lastName);

    @Query("{'groupList' : ?0}")
    List<Contact> findByContactGroup(String group);

}
