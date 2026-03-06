package com.cesizen.dto.response;

import com.cesizen.entity.BreathingExercice.DifficultyLevel;
import com.cesizen.entity.BreathingExercice.ExerciceStatus;

/**
 * DTO de réponse — Exercice de respiration.
 */
public record BreathingExerciceResponse(
        Integer id,
        String reference,
        String name,
        String description,
        Integer durationInhale,
        Integer durationHold,
        Integer durationExhale,
        Integer totalCycles,
        DifficultyLevel difficultyLevel,
        ExerciceStatus status
) {}