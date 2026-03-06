package com.CESIZen.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entité représentant un exercice de respiration de CESIZen.
 * Correspond à la table `breathing_exercices` en base de données.
 *  Les trois exercices initiaux définis dans le cahier des charges :
 *     - 748 : inspire=7s, hold=4s, expire=8s
 *     - 55  : inspire=5s, hold=0s, expire=5s
 *     - 46  : inspire=4s, hold=0s, expire=6s
 */

@Entity
@Table(name = "breathing_exercices")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class BreathingExercice{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_breathing")
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    private String reference;

    @Column(nullable = false, length = 255)
    private String name;

    /**
     * Statut de l'exercice de respiration.
     * La transition entre statuts est validée dans BreathingExerciceService,
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ExerciceStatus status = ExerciceStatus.active;

    @Column(name = "total_cycles")
    private Integer totalCycles;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "duration_inhale", nullable = false)
    private Integer durationInhale;

    @Column(name = "duration_hold", nullable = false)
    private Integer durationHold;

    @Column(name = "duration_exhale", nullable = false)
    private Integer durationExhale;

    /**
     * Niveau de difficulté de l'exercice de respiration.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level")
    private DifficultyLevel difficultyLevel;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Relation

    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY)
    private List<BreathingSession> sessions;

    // Enum

    public enum ExerciceStatus {active, inactive}

    public enum DifficultyLevel { beginner, intermediate, advanced}
}