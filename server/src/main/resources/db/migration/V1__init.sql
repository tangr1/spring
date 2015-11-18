# noinspection SqlNoDataSourceInspectionForFile
CREATE TABLE `topics` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `content`     TEXT                  DEFAULT NULL,
  `category`    VARCHAR(64)           DEFAULT NULL,
  `ctocoins`    BIGINT(20)            DEFAULT NULL,
  `confirmed`   CHAR(1)               DEFAULT NULL,
  `title`       VARCHAR(255) NOT NULL,
  `labels`      VARCHAR(255) NOT NULL,
  `user_id`     BIGINT(20)   NOT NULL,
  `created_at`  DATETIME              DEFAULT NULL,
  `modified_at` DATETIME              DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `comments` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `content`     VARCHAR(255)        DEFAULT NULL,
  `reply_id`    BIGINT(20)          DEFAULT NULL,
  `topic_id`    BIGINT(20)          DEFAULT NULL,
  `user_id`     BIGINT(20)          DEFAULT NULL,
  `created_at`  DATETIME            DEFAULT NULL,
  `modified_at` DATETIME            DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `replies` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `content`     TEXT                DEFAULT NULL,
  `title`       VARCHAR(255)        DEFAULT NULL,
  `topic_id`    BIGINT(20)          DEFAULT NULL,
  `user_id`     BIGINT(20)          DEFAULT NULL,
  `created_at`  DATETIME            DEFAULT NULL,
  `modified_at` DATETIME            DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `users` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `email`       VARCHAR(64)           DEFAULT NULL,
  `name`        VARCHAR(255) NOT NULL,
  `password`    VARCHAR(255) NOT NULL,
  `phone`       VARCHAR(64)           DEFAULT NULL,
  `role`        VARCHAR(64)           DEFAULT NULL,
  `startup_id`  BIGINT(20)            DEFAULT NULL,
  `created_at`  DATETIME              DEFAULT NULL,
  `modified_at` DATETIME              DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `startups` (
  `id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
  `corp_id_photo` VARCHAR(255)        DEFAULT NULL,
  `corp_name`     VARCHAR(255)        DEFAULT NULL,
  `location`      VARCHAR(255)        DEFAULT NULL,
  `logo`          VARCHAR(255)        DEFAULT NULL,
  `name`          VARCHAR(255)        DEFAULT NULL,
  `phase`         VARCHAR(255)        DEFAULT NULL,
  `product_desc`  VARCHAR(255)        DEFAULT NULL,
  `product_name`  VARCHAR(255)        DEFAULT NULL,
  `scope`         VARCHAR(255)        DEFAULT NULL,
  `start_month`   INT(11)             DEFAULT NULL,
  `start_year`    INT(11)             DEFAULT NULL,
  `intro`         TEXT                DEFAULT NULL,
  `admin_id`      BIGINT(20)          DEFAULT NULL,
  `created_at`    DATETIME            DEFAULT NULL,
  `modified_at`   DATETIME            DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `founders` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email`       VARCHAR(255)        DEFAULT NULL,
  `name`        VARCHAR(255)        DEFAULT NULL,
  `position`    VARCHAR(255)        DEFAULT NULL,
  `intro`       VARCHAR(255)        DEFAULT NULL,
  `startup_id`  BIGINT(20)          DEFAULT NULL,
  `created_at`  DATETIME            DEFAULT NULL,
  `modified_at` DATETIME            DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO users (name, password, role)
VALUES ('root', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROOT');
