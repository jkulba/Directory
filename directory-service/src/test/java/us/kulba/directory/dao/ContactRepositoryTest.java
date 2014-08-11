package us.kulba.directory.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.kulba.directory.config.TestConfig;
import us.kulba.directory.model.Contact;

/**
 * Junit test to exercise the ContactRepository DAO methods.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ContactRepositoryTest {
    final Logger logger = LoggerFactory.getLogger(ContactRepositoryTest.class);

    @Autowired
    ContactRepository contactRepository;

    @Before
    public void setup() {
        logger.info("ContactRepositoryTest - deleteAll Contacts");
        contactRepository.deleteAll();
    }

    @Test
    public void saveContactTest(){
        logger.info("Save new contact");
        Contact c = populateContact();
        contactRepository.save(c);

    }

    private Contact populateContact(){
        Contact contact = new Contact();

        contact.setFirstName("Joseph");
        contact.setLastName("Kulba");
        contact.setNickname("Joe");

        return contact;
    }


}
