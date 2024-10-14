package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.repositories.RoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        // Load Spring Application Context
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        // Get the RoleRepository bean from the context
        RoleRepository roleRepository = context.getBean(RoleRepository.class);

        // Test inserting a role
        Role role = new Role();
        role.setName("ADMIN");
        roleRepository.save(role); // Save to the database

        // Test retrieving all roles
        List<Role> roles = roleRepository.findAll();
        System.out.println("Roles in the database:");
        roles.forEach(r -> System.out.println(r.getId() + ": " + r.getName()));

        // Test retrieving a specific role by ID
        Role foundRole = roleRepository.findById(role.getId()).orElse(null);
        System.out.println("Found role by ID: " + foundRole.getName());

        // Test deleting a role
        roleRepository.deleteById(role.getId());
        System.out.println("Deleted role with ID: " + role.getId());

        // Verify deletion
        List<Role> updatedRoles = roleRepository.findAll();
        System.out.println("Remaining roles after deletion:");
        updatedRoles.forEach(r -> System.out.println(r.getId() + ": " + r.getName()));
    }

}
