package com.CESIZen.dto.response;

import com.CESIZen.entity.User.UserRole;

/**
 * DTO de réponse — Authentification réussie.
 * Retourne le token JWT et les informations minimales pour le frontend.
 *
 * Le `refreshToken` permet de renouveler le JWT sans ré-authentification.
 * C'est la mitigation principale au problème de révocation de token
 * (ex: compte suspendu avec JWT encore valide).
 */
public record AuthResponse(
        String accessToken,
        String refreshToken,
        String tokenType,
        Long expiresIn,
        Integer userId,
        String username,
        UserRole role
) {
    /** Constructeur avec valeurs par défaut. */
    public AuthResponse(String accessToken, String refreshToken, Long expiresIn,
                        Integer userId, String username, UserRole role) {
        this(accessToken, refreshToken, "Bearer", expiresIn, userId, username, role);
    }
}