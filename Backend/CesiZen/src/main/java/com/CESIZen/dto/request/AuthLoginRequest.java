package com.cesizen.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO de requête — Authentification (login).
 * Retourne un JWT en cas de succès.
 */
public record AuthLoginRequest(

        @NotBlank(message = "Le nom d'utilisateur est obligatoire")
        String username,

        @NotBlank(message = "Le mot de passe est obligatoire")
        String password

) {}