package com.CESIZen.dto.response;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de réponse standardisé pour toutes les erreurs de l'API.
 * Retourné par le GlobalExceptionHandler (@ControllerAdvice).
 *
 * Format uniforme :
 * {
 *   "timestamp": "2026-02-25T10:00:00",
 *   "status": 400,
 *   "error": "Bad Request",
 *   "message": "Validation échouée",
 *   "path": "/api/users",
 *   "details": ["Le nom d'utilisateur est obligatoire", ...]
 * }
 */
public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        List<String> details
) {
    /** Constructeur simplifié sans détails (erreurs non-validation). */
    public static ErrorResponse of(int status, String error, String message, String path) {
        return new ErrorResponse(LocalDateTime.now(), status, error, message, path, List.of());
    }

    /** Constructeur avec détails (erreurs de validation Bean Validation). */
    public static ErrorResponse of(int status, String error, String message, String path, List<String> details) {
        return new ErrorResponse(LocalDateTime.now(), status, error, message, path, details);
    }
}