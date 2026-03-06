/*

Script de création de la base de donnée pour le projet CesiZen

Auteur : T.HERVEUX
Création : 06/02/2026

*/

CREATE TABLE users(
   Id_users INT AUTO_INCREMENT,
   username VARCHAR(255)  NOT NULL,
   password VARCHAR(255)  NOT NULL,
   mail VARCHAR(255)  NOT NULL,
   last_login DATETIME,
   first_name VARCHAR(255) ,
   last_name VARCHAR(255) ,
   status ENUM('active','suspended','deleted') NOT NULL DEFAULT 'active',
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   role ENUM('Anonyme_User','Connected_User','Administrator') NOT NULL DEFAULT 'Anonyme_User',
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY(Id_users),
   UNIQUE(username),
   UNIQUE(mail)
);

CREATE TABLE informations(
   Id_informations INT AUTO_INCREMENT,
   description TEXT NOT NULL,
   content TEXT NOT NULL,
   image_url VARCHAR(500) ,
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   title VARCHAR(255)  NOT NULL,
   source VARCHAR(255) ,
   information_status ENUM('draft','review','published','archived') NOT NULL DEFAULT 'draft',
   modified_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   published_at DATETIME,
   archived_at DATETIME,
   Id_users INT NOT NULL,
   PRIMARY KEY(Id_informations),
   FOREIGN KEY(Id_users) REFERENCES users(Id_users) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE breathing_exercices(
   Id_breathing INT AUTO_INCREMENT,
   reference VARCHAR(50)  NOT NULL,
   name VARCHAR(255)  NOT NULL,
   status ENUM('active','inactive') NOT NULL DEFAULT 'active',
   total_cycles INT,
   description TEXT,
   duration_inhale INT NOT NULL,
   duration_hold INT NOT NULL,
   duration_exhale INT NOT NULL,
   difficulty_level ENUM ('beginner', 'intermediate', 'advanced'),
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY(Id_breathing),
   UNIQUE(reference)
);

CREATE TABLE breathing_sessions(
   Id_breathing_sessions INT AUTO_INCREMENT,
   started_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   ended_at DATETIME,
   cycles_completed INT NOT NULL DEFAULT 0,
   feeling_before ENUM ('stressed' ,'neutral', 'calm'),
   feeling_after ENUM ('stressed' ,'neutral', 'calm'),
   heart_rate_before SMALLINT,
   heart_rate_after SMALLINT,
   notes TEXT,
   completed BOOLEAN NOT NULL DEFAULT 0,
   Id_breathing INT NOT NULL,
   Id_users INT,
   PRIMARY KEY(Id_breathing_sessions),
   FOREIGN KEY(Id_breathing) REFERENCES breathing_exercices(Id_breathing) ON DELETE RESTRICT ON UPDATE CASCADE,
   FOREIGN KEY(Id_users) REFERENCES users(Id_users) ON DELETE SET NULL ON UPDATE CASCADE
);
