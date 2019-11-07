package com.wzt.springboot.springboot.repository;

import com.wzt.springboot.springboot.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);

}
