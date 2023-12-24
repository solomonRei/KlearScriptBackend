CREATE TABLE messages
(
    id            BIGSERIAL PRIMARY KEY,
    sender_id     BIGINT NOT NULL,
    message_date  TIMESTAMP,
    message       TEXT,
    receiver_name TEXT,
    status        VARCHAR(255) CHECK (status IN ('JOIN', 'MESSAGE', 'LEAVE'))
);