package com.CESIZen.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO de requête — Création d'un compte utilisateur (inscription).
 * Accessible au visiteur anonyme.
 *
 * La validation Bean Validation (@Valid dans le Controller) est déclenchée
 * avant d'atteindre le Service, conformément à l'architecture en couches.
 */
public record UserCreateRequest(

        @NotBlank(message = "Le nom d'utilisateur est obligatoire")
        @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit contenir entre 3 et 50 caractères")
        String username,

        @NotBlank(message = "L'email est obligatoire")
        @Email(message = "Format d'email invalide")
        String mail,

        @NotBlank(message = "Le mot de passe est obligatoire")
        @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
        String password,

        @Size(max = 100)
        String firstName,

        @Size(max = 100)
        String lastName

) {}