package com.billdog.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.billdog.user.entity.Organization;
import com.billdog.user.entity.Roles;
import com.billdog.user.entity.SystemUsers;

@Repository
public interface SystemUsersrepository extends JpaRepository<SystemUsers, Long> {

	@Query(value = "SELECT su.id, concat(su.first_name,' ',su.last_name,' ',su.middle_name) as user_name,su.email,su.mobile_number,r.role\n" + 
			"			FROM billdog_user.system_users su\n" + 
			"           join roles r on r.id = su.role_id\n" + 
			"			where CASE WHEN COALESCE(?1,'') <> '' THEN su.first_name ELSE '' END LIKE COALESCE(?2,'') AND \n" + 
			"			CASE WHEN COALESCE(?3,'') <> '' THEN su.last_name ELSE '' END LIKE COALESCE(?4,'') AND \n" + 
			"			CASE WHEN COALESCE(?5,'') <> '' THEN su.mobile_number ELSE '' END LIKE COALESCE(?6,'') AND\n" + 
			"			CASE WHEN COALESCE(?7,'') <> '' THEN su.email ELSE '' END LIKE COALESCE(?8,'') AND\n" + 
			"           CASE WHEN COALESCE(?9,-999) <> -999 THEN su.role_id ELSE -999 END = COALESCE(?10,-999)", nativeQuery = true)

	Object[][] getUserDetails(String userFirstName, String userFirstName2, String userLastName, String userLastName2,
			String mobileNumber, String mobileNumber2, String email, String email2, Long roleId, Long roleId2);

	Optional<SystemUsers> findByRoleId(Roles role);

	Optional<SystemUsers> findByOrganizationId(Organization organization);

	

}
