package com.CESIZen.dto.request;

import com.CESIZen.entity.Information.InformationStatus;
import jakarta.validation.constraints.NotNull;

/**
 * DTO de requête — Changement de statut d'une information.
 * Endpoint dédié : PATCH /api/informations/{id}/status
 *
 * Séparer ce DTO du InformationRequest permet de :
 *  1. Contrôler les transitions de statut dans le Service (règle métier)
 *  2. Éviter qu'un admin modifie contenu ET statut en une seule requête non contrôlée
 */
public record InformationStatusRequest(

        @NotNull(message = "Le nouveau statut est obligatoire")
        InformationStatus newStatus

) {}