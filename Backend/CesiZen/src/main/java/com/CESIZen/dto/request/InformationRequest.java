package com.CESIZen.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO de requête — Création ou modification d'une information.
 * Réservé aux administrateurs.
 *
 * Note : le changement de statut (draft → review → published → archived)
 * est géré par un endpoint dédié (PATCH /informations/{id}/status)
 * et non via ce DTO, afin de contrôler explicitement les transitions
 * dans InformationService.
 */
public record InformationRequest(

        @NotBlank(message = "Le titre est obligatoire")
        @Size(max = 255)
        String title,

        @NotBlank(message = "La description est obligatoire")
        String description,

        @NotBlank(message = "Le contenu est obligatoire")
        String content,

        @Size(max = 500)
        String imageUrl,

        @Size(max = 255)
        String source

) {}