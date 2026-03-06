package com.CESIZen.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * DTO de requête — Mise à jour du profil utilisateur.
 * Accessible à l'utilisateur connecté pour son propre compte.
 * Tous les champs sont optionnels : seuls les champs non-null sont mis à jour.
 */
public record UserUpdateRequest(

        @Email(message = "Format d'email invalide")
        String mail,

        @Size(max = 100)
        String firstName,

        @Size(max = 100)
        String lastName

) {}