package com.cesizen.repository;

import com.cesizen.entity.BreathingExercice;
import com.cesizen.entity.BreathingExercice.ExerciceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository Spring Data JPA pour l'entité BreathingExercice.
 */
@Repository
public interface BreathingExerciceRepository extends JpaRepository<BreathingExercice, Integer> {

    List<BreathingExercice> findByStatus(ExerciceStatus status);

    Optional<BreathingExercice> findByReference(String reference);
}