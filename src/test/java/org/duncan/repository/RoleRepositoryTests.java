package org.duncan.repository;

import static org.junit.Assert.assertEquals;

import org.duncan.Application;
import org.duncan.entity.Role;
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
public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void testFindByRole(){
		Role role = roleRepository.findByRole("ADMIN");
		assertEquals(1, role.getId());
	}
	
}
