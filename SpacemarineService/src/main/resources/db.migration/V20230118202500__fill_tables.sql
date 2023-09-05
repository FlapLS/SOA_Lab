CREATE SEQUENCE IF NOT EXISTS starship_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE starship
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255),
    fleet        VARCHAR(255),
    coordinate_x INTEGER,
    coordinate_y BIGINT,
    CONSTRAINT pk_starship PRIMARY KEY (id)
);


CREATE SEQUENCE IF NOT EXISTS spacemarine_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE spacemarine
(
    id                BIGINT NOT NULL,
    name              VARCHAR(255),
    coordinate_x      INTEGER,
    coordinate_y      BIGINT,
    creation_date     TIMESTAMP with time zone,
    health            BIGINT,
    astartes_category VARCHAR(255),
    weapon_type       VARCHAR(255),
    melee_weapon      VARCHAR(255),
    starship_id       BIGINT,
    CONSTRAINT pk_spacemarine PRIMARY KEY (id)
);

ALTER TABLE spacemarine
    ADD CONSTRAINT FK_SPACEMARINE_ON_STARSHIP FOREIGN KEY (starship_id) REFERENCES starship (id);