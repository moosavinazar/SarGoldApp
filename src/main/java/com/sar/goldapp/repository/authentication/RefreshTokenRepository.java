package com.sar.goldapp.repository.authentication;

import com.sar.goldapp.model.authentication.RefreshToken;
import com.sar.goldapp.model.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String Token);

    Optional<RefreshToken> findByUserId(long id);

    @Modifying
    int deleteByUser(User user);

}
