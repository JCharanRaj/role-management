package com.billdog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billdog.user.entity.NavigationScreens;

@Repository
public interface NavigationScreensRepository extends JpaRepository<NavigationScreens,Long> {

}
