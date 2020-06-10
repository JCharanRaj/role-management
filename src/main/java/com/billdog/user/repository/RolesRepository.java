package com.billdog.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billdog.user.entity.Organization;
import com.billdog.user.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

	List<Roles> findByOrganizationId(Organization organization);

	Optional<Roles> findByRoleAndOrganizationId(String name, Organization organization);

}
