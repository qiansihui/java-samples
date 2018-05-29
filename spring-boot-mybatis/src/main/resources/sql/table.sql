-- auto-generated definition
CREATE TABLE article
(
  id          BIGINT AUTO_INCREMENT
  PRIMARY KEY,
  title       VARCHAR(200) NOT NULL,
  brief       VARCHAR(255) NOT NULL,
  content     TEXT         NULL,
  create_time DATETIME     NOT NULL,
  update_time DATETIME     NOT NULL
);
