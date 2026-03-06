package com.CESIZen.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Entité représentant une session de respiration réalisée.
 * Correspond à la table `breathing_sessions` en base de données.
 * Particularité : l'utilisateur est nullable (ON DELETE SET NULL).
 * Une session peut être anonyme — le visiteur non connecté peut faire
 * un exercice sans compte. Dans ce cas, user = null.
 */

@Entity
@Table (name = "breathing_sessions")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class BreathingSession{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_breathing_sessions")
    private Integer Id;

    @CreatedDate
    @Column(name = "started_at", nullable = false, updatable = false)
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "cycles_completed", nullable = false)
    @Builder.Default
    private Integer cyclesCompleted = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "feeling_before")
    private Feeling feelingBefore;

    @Enumerated(EnumType.STRING)
    @Column(name = "feeling_after")
    private Feeling feelingAfter;

    @Column(name = "heart_rate_before")
    private Integer heartRateBefore;

    @Column(name = "heart_rate_after")
    private Integer heartRateAfter;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    @Builder.Default
    private Boolean completed = false;

    // Relation

    /**
     * Exercice lié — obligatoire (ON DELETE RESTRICT).
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_breathing", nullable = false)
    private BreathingExercice exercise;

    /**
     * Utilisateur lié — nullable pour les sessions anonymes.
     * ON DELETE SET NULL : si le compte est supprimé, la session est conservée.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "Id_users", nullable = true)
    private User user;

    // Enum

    public enum Feeling {stressed, neutral, calm}
}