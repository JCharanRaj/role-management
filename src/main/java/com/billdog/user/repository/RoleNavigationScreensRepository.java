package com.billdog.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billdog.user.entity.Organization;
import com.billdog.user.entity.RoleNavigationScreens;
import com.billdog.user.entity.Roles;

@Repository
public interface RoleNavigationScreensRepository extends JpaRepository<RoleNavigationScreens,Long> {

	List<RoleNavigationScreens> findByRoleIdAndOrganizationId(Roles role,
			Organization organizationId);


}