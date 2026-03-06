package com.cesizen.dto.request;

import com.cesizen.entity.BreathingSession.Feeling;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * DTO de requête — Clôture d'une session de respiration.
 * Endpoint : PATCH /api/breathing-sessions/{id}/complete
 */
public record BreathingSessionCompleteRequest(

        @NotNull
        @Min(value = 0, message = "Le nombre de cycles ne peut pas être négatif")
        Integer cyclesCompleted,

        /** Ressenti après l'exercice — optionnel. */
        Feeling feelingAfter,

        /** Fréquence cardiaque après — optionnel. */
        Short heartRateAfter,

        String notes

) {}