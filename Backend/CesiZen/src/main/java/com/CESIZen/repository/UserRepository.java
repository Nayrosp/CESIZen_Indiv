package com.CESIZen.repository;

import com.CESIZen.entity.User;
import com.CESIZen.entity.User.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository Spring Data JPA pour l'entité User.
 * Les opérations CRUD de base sont héritées de JpaRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findByMail(String mail);

    boolean existsByUsername(String username);

    boolean existsByMail(String mail);

    /** Utilisé par l'admin pour lister les comptes par statut. */
    java.util.List<User> findAllByStatus(UserStatus status);
}