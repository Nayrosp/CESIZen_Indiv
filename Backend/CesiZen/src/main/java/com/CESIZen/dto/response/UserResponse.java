package com.CESIZen.dto.response;

import com.CESIZen.entity.User.UserRole;
import com.CESIZen.entity.User.UserStatus;

import java.time.LocalDateTime;

/**
 * DTO de réponse — Profil utilisateur.
 * Le champ `password` est intentionnellement absent.
 * Ce DTO est retourné aussi bien à l'utilisateur pour son propre profil
 * qu'à l'admin pour la gestion des comptes.
 */
public record UserResponse(
        Integer id,
        String username,
        String mail,
        String firstName,
        String lastName,
        UserStatus status,
        UserRole role,
        LocalDateTime lastLogin,
        LocalDateTime createdAt
) {}