package com.SecureBlog.SecureBlog.repos;

import com.SecureBlog.SecureBlog.Entity.RoleTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<RoleTypes, Long> {
    Optional<RoleTypes> findByName(String name);
}
