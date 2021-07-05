CREATE TABLE authorities (
  id SERIAL PRIMARY KEY,
  authority VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  enabled BOOLEAN DEFAULT TRUE,
  authority_id INT NOT NULL REFERENCES authorities(id)
);

CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200),
    description TEXT,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    author_id INT NOT NULL REFERENCES users(id)
);

CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    text TEXT,
    created TIMESTAMP,
    author_id INT NOT NULL REFERENCES users(id)
);