CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS users(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR NOT NULL,
    email VARCHAR NOT NULl,
    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT uq_email UNIQUE(email)
);

CREATE TABLE IF NOT EXISTS categories(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id),
    CONSTRAINT uq_category_name UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS locations(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    lat FLOAT,
    lon FLOAT,
    CONSTRAINT pr_location PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS requests(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created TIMESTAMP,
    event BIGINT,
    requester BIGINT,
    status VARCHAR,
    CONSTRAINT pk_request PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS compilations(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title VARCHAR,
    pinned BOOLEAN,
    CONSTRAINT pr_compilation PRIMARY KEY (id),
    CONSTRAINT uq_compilation_name UNIQUE(title)
);

CREATE TABLE IF NOT EXISTS events(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title VARCHAR(120),
    annotation VARCHAR(2000),
    category BIGINT,
    description VARCHAR(7000),
    event_date TIMESTAMP,
    initiator BIGINT,
    location BIGINT,
    paid BOOLEAN,
    participant_limit BIGINT,
    request_moderation BOOLEAN,
    confirmed_requests INT,
    created_on TIMESTAMP,
    published_on TIMESTAMP,
    state VARCHAR,
    views BIGINT,
    CONSTRAINT pk_event PRIMARY KEY (id),
    CONSTRAINT fk_category FOREIGN KEY (category) REFERENCES categories(id),
    CONSTRAINT fk_location FOREIGN KEY (location) REFERENCES locations(id),
    CONSTRAINT fk_initiator FOREIGN KEY (initiator) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS comments(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    event_id BIGINT,
    author BIGINT,
    text VARCHAR(7000),
    created TIMESTAMP,
    CONSTRAINT pk_comment PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (author) REFERENCES users(id),
    CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE IF NOT EXISTS compilation_list(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    id_compilation BIGINT,
    id_event BIGINT,
    CONSTRAINT pk_compilation_list PRIMARY KEY (id),
    CONSTRAINT fk_compilation FOREIGN KEY (id_compilation) REFERENCES compilations(id),
    CONSTRAINT fk_event FOREIGN KEY (id_event) REFERENCES events(id)
);

