CREATE TABLE demo.t_user
(
    id          BIGINT UNSIGNED                        NOT NULL AUTO_INCREMENT,
    gender      int(1) unsigned                        NULL,
    username    varchar(128) DEFAULT ''                NOT NULL,
    mobile      varchar(64)  DEFAULT ''                NOT NULL,
    email       varchar(64)  DEFAULT ''                NOT NULL,
    create_time TIMESTAMP    DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT t_user_PK PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci;
