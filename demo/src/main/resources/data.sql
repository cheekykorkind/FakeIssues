-- INSERT INTO city (name, state, country) VALUES ('San Francisco', 'CA', 'US'); 

-- INSERT INTO users (name, password) VALUES ('user1', 'password');

    -- username varchar(255) NULL DEFAULT NULL,
    -- password VARCHAR(500) NULL DEFAULT NULL,
    -- isAccountNonExpired boolean,
    -- isAccountNonLocked boolean,
    -- isCredentialsNonExpired boolean,
    -- isEnabled boolean

    --     username varchar(20),
    -- authority_name varchar(20)

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