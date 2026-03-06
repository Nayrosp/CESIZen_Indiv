package com.CESIZen.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entité représentant un utilisateur de l'application CESIZen.
 * Correspond à la table `users` en base de données.
 */

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_users")
    private Integer id;

    @Column(nullable = false, unique = true, length = 255)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false,unique = true, length = 255)
    private String mail;

    @Column(name = "Last_login")
    private LocalDateTime lastLogin;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    /**
     * Statut du compte.
     * - active
     * - suspended
     * - deleted
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private UserStatus status = UserStatus.active;

    /**
     * Rôle de l'utilisateur pour l'autorisation.
     * - Administrator  : administrateur
     * - Connected_User : utilisateur standard
     * - Anonyme_User : utilisateur anonyme
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private UserRole role = UserRole.Anonyme_User;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private  LocalDateTime updatedAt;

    // Relation

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Information> informations;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BreathingSession> breathingSessions;

    // Enum

    public enum UserStatus { active, suspended, deleted }

    public enum UserRole { Administrator, Connected_User, Anonyme_User }
}