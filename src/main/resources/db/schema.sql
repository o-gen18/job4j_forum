CREATE TABLE authorities (
    id SERIAL PRIMARY KEY,
    authority VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    created TIMESTAMP NOT NULL DEFAULT NOW(),
    user_id INT NOT NULL,
    CONSTRAINT USER_ID_FK FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT NOW(),
    user_id INT NOT NULL,
    CONSTRAINT USER_ID_FK FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE posts_comments (
    post_id INT NOT NULL,
    comments_id INT NOT NULL,
    CONSTRAINT POST_ID_FK FOREIGN KEY (post_id) REFERENCES posts(id),
    CONSTRAINT COMMENT_ID_FK FOREIGN KEY (comments_id) REFERENCES comments(id)
);

CREATE UNIQUE INDEX posts_comments_pkey ON posts_comments(post_id, comments_id);

CREATE TABLE users_authorities (
    user_id INT NOT NULL,
    authorities_id INT NOT NULL,
    CONSTRAINT POST_ID_FK FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT AUTHORITY_ID_FK FOREIGN KEY (authorities_id) REFERENCES authorities(id)
);

CREATE UNIQUE INDEX users_authorities_pkey ON users_authorities(user_id, authorities_id);

