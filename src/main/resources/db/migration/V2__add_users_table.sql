CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled) VALUES
('user', '{noop}jdbcDefault', TRUE);

INSERT INTO authorities (username, authority) VALUES
('user', 'ROLE_USER');