package com.CESIZen.dto.response;

import com.CESIZen.entity.BreathingSession.Feeling;

import java.time.LocalDateTime;

/**
 * DTO de réponse — Session de respiration.
 * L'userId peut être null pour les sessions anonymes.
 */
public record BreathingSessionResponse(
        Integer id,
        Integer exerciseId,
        String exerciseName,
        Integer userId,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        Integer cyclesCompleted,
        Feeling feelingBefore,
        Feeling feelingAfter,
        Short heartRateBefore,
        Short heartRateAfter,
        String notes,
        Boolean completed
) {}