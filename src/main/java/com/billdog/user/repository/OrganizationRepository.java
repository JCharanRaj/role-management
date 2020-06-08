package com.billdog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billdog.user.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {

	Organization findByName(String name);

}
