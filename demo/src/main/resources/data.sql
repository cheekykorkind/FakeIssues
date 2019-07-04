INSERT INTO user (username, password, name, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled)
    VALUES ('user1', 'password', 'smallName1', 1, 1, 1, 1);
INSERT INTO user (username, password, name, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled)
    VALUES ('user2', 'password', 'smallName2', 1, 1, 1, 1);

INSERT INTO authority (username, authority_name)
    VALUES ('user1', 'ADMIN');
INSERT INTO authority (username, authority_name)
    VALUES ('user1', 'USER');
INSERT INTO authority (username, authority_name)
    VALUES ('user2', 'USER');