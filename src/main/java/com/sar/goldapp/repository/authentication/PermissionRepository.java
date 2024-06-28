package com.sar.goldapp.repository.authentication;

import com.sar.goldapp.model.authentication.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
