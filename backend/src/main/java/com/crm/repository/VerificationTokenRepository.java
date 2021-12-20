package com.crm.repository;

import com.crm.model.db.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Long> {

    Optional<VerificationTokenEntity> findByToken(final String token);

    @Modifying
    @Query("DELETE FROM VerificationTokenEntity t WHERE t.user.id = :id")
    void deleteByUserId(final Long id);
}
