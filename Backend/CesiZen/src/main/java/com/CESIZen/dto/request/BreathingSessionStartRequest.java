package com.CESIZen.dto.request;

import com.CESIZen.entity.BreathingSession.Feeling;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * DTO de requête — Démarrage d'une session de respiration.
 * Accessible aux visiteurs anonymes ET aux utilisateurs connectés.
 *
 * Si la requête arrive sans JWT, le Service recevra userId = null
 * et créera une session anonyme. Le SecurityConfig doit donc exposer
 * cet endpoint publiquement (permitAll).
 */
public record BreathingSessionStartRequest(

        @NotNull(message = "L'identifiant de l'exercice est obligatoire")
        @Positive
        Integer exerciseId,

        /** Ressenti avant l'exercice — optionnel. */
        Feeling feelingBefore,

        /** Fréquence cardiaque avant — optionnel. */
        Short heartRateBefore

) {}