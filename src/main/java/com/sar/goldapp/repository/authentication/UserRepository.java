package com.sar.goldapp.repository.authentication;

import com.sar.goldapp.model.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByPersonId(long personId);

    boolean existsUserByCode(String code);

    @Query(value = "select distinct u.* from auth_user as u inner join auth_user_groups as up on u.id = up.user_id where up.groups_id in (1, 2, 3)", nativeQuery = true)
    List<User> findAllAdminAndSuperAdminUsers();

    @Query(value = "select u.* from auth_user as u inner join auth_user_price_groups as up on u.id = up.user_id where up.price_groups_id = ?1", nativeQuery = true)
    List<User> findAllByPriceGroupId(long priceGroupId);

}
