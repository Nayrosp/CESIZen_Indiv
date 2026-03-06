package com.CESIZen.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Entité représentant un contenu informationnel de CESIZen.
 * Correspond à la table `informations` en base de données.
 */

@Entity
@Table(name = "informations")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class Information{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_informations")
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "Text")
    private String content;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, length = 255)
    private String tittle;

    @Column(length = 255)
    private String source;

    /**
     * Statut de publication.
     * La transition entre statuts est validée dans InformationService,
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "information_status", nullable = false)
    @Builder.Default
    private InformationStatus informationStatus = InformationStatus.draft;

    @LastModifiedDate
    @Column(name = "modified_at", nullable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "archived_at")
    private LocalDateTime archivedAt;

    // Relation

    /**
     * Auteur de l'information — toujours un admin.
     * ON DELETE RESTRICT : suppression d'un user impossible s'il a des informations.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_users", nullable = false)
    private User author;

    // Enum

    public enum InformationStatus { draft, review, published, archived }
}