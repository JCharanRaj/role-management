package com.billdog.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billdog.user.entity.NavigationScreen;
import com.billdog.user.entity.Organization;

@Repository
public interface NavigationScreenRepository extends JpaRepository<NavigationScreen,Long> {

	List<NavigationScreen> findByOrganizationId(Organization organization);

}
