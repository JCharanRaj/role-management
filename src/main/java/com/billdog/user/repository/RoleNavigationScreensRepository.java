package com.billdog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billdog.user.entity.RoleNavigationScreens;

@Repository
public interface RoleNavigationScreensRepository extends JpaRepository<RoleNavigationScreens,Long> {


}