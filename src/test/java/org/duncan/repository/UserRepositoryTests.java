package org.duncan.repository;

import static org.junit.Assert.assertEquals;

import org.duncan.Application;
import org.duncan.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = Application.class) 
@DataJpaTest
public class UserRepositoryTests {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        User user = userRepository.findByEmail("smyrna.trk@gmail.com");
        assertEquals("Cihan", user.getName());
    }

}
