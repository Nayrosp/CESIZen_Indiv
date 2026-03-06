package com.cesizen.repository;

import com.cesizen.entity.Information;
import com.cesizen.entity.Information.InformationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Spring Data JPA pour l'entité Information.
 */
@Repository
public interface InformationRepository extends JpaRepository<Information, Integer> {

    /**
     * Liste paginée des informations publiées — accessible au Front-Office
     * (visiteurs anonymes et utilisateurs connectés).
     */
    Page<Information> findByInformationStatus(InformationStatus status, Pageable pageable);

    /**
     * Toutes les informations d'un auteur donné — utilisé par le Back-Office admin.
     */
    java.util.List<Information> findByAuthorId(Integer authorId);
}