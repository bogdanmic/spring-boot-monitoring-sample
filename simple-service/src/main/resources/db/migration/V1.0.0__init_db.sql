CREATE TABLE IF NOT EXISTS simple_service_contacts
(
    id              BIGINT      NOT NULL PRIMARY KEY,
    first_name      VARCHAR(32),
    last_name       VARCHAR(32) NOT NULL
);