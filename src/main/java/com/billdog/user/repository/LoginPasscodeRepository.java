package com.billdog.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billdog.user.entity.VerifyPasscode;

public interface LoginPasscodeRepository extends JpaRepository<VerifyPasscode, Long> {

	Optional<VerifyPasscode> findByEmailAndPasscode(String email, String passcode);

	Optional<VerifyPasscode> findByEmail(String email);

}
