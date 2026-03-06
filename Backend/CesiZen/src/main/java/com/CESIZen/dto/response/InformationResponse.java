package com.cesizen.dto.response;

import com.cesizen.entity.Information.InformationStatus;

import java.time.LocalDateTime;

/**
 * DTO de réponse — Contenu informationnel.
 * Le nom de l'auteur est inclus (dénormalisé) pour éviter un appel
 * supplémentaire au frontend.
 */
public record InformationResponse(
        Integer id,
        String title,
        String description,
        String content,
        String imageUrl,
        String source,
        InformationStatus status,
        String authorUsername,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt,
        LocalDateTime publishedAt
) {}