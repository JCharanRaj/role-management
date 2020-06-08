package com.billdog.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billdog.user.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

	Optional<Roles> findByOrganizationId(long userId);

}
