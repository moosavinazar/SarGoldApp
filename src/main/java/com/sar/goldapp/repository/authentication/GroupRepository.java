package com.sar.goldapp.repository.authentication;

import com.sar.goldapp.model.authentication.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
