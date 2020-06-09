package com.billdog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billdog.user.entity.NavigationScreen;

@Repository
public interface NavigationScreenRepository extends JpaRepository<NavigationScreen,Long> {

}
