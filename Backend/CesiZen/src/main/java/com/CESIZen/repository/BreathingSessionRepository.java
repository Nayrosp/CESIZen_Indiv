package com.CESIZen.repository;

import com.CESIZen.entity.BreathingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Spring Data JPA pour l'entité BreathingSession.
 */
@Repository
public interface BreathingSessionRepository extends JpaRepository<BreathingSession, Integer> {

    /** Historique des sessions d'un utilisateur connecté. */
    List<BreathingSession> findByUserIdOrderByStartedAtDesc(Integer userId);

    /** Sessions liées à un exercice donné — statistiques admin. */
    List<BreathingSession> findByExerciseId(Integer exerciseId);
}