package com.empmng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empmng.config.AppConstants;
import com.empmng.entities.Role;
import com.empmng.repo.RoleRepo;

@SpringBootApplication
public class EmpmanagementApplication implements CommandLineRunner {

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(EmpmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_USER");

			List<Role> roles = List.of(role, role1);

			this.roleRepo.saveAll(roles);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
