package com.billdog.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billdog.user.entity.EmailAndPassword;

public interface UpdatePasswordRepository extends JpaRepository<EmailAndPassword, Long> {

	Optional<EmailAndPassword> findByEmail(String username);


}
