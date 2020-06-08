package com.billdog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billdog.user.entity.NamePrefixMaster;

public interface NamePrefixMasterRepository extends JpaRepository<NamePrefixMaster, Long> {

}
