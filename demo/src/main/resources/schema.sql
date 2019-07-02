-- DROP TABLE IF EXISTS city;
-- CREATE TABLE city (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255),
--     state VARCHAR(255),
--     country VARCHAR(255)
-- );
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) NULL DEFAULT NULL,
    password VARCHAR(500) NULL DEFAULT NULL,
    isAccountNonExpired boolean,
    isAccountNonLocked boolean,
    isCredentialsNonExpired boolean,
    isEnabled boolean
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
 

DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
    username varchar(20),
    authority_name varchar(20)
);