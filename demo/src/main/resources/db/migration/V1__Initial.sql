CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NULL DEFAULT NULL,
    name VARCHAR(20) NULL DEFAULT NULL,
    password VARCHAR(500) NULL DEFAULT NULL,
    isAccountNonExpired TINYINT(1) NULL DEFAULT NULL,
    isAccountNonLocked TINYINT(1) NULL DEFAULT NULL,
    isCredentialsNonExpired TINYINT(1) NULL DEFAULT NULL,
    isEnabled TINYINT(1) NULL DEFAULT NULL
)
default character set = utf8;

CREATE TABLE authority (
    username VARCHAR(20) NULL DEFAULT NULL,
    authority_name VARCHAR(20) NULL DEFAULT NULL
);