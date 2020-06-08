package com.billdog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billdog.user.entity.SystemUsers;

public interface SystemUsersrepository extends JpaRepository<SystemUsers, Long>{

}
