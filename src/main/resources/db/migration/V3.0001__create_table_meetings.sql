CREATE TABLE IF NOT EXISTS meetings
(
    id bigserial NOT NULL PRIMARY KEY,
    official_id BIGINT NOT NULL,
    meeting_link VARCHAR(255),
    meeting_date TIMESTAMP(6),
    FOREIGN KEY (official_id) REFERENCES officials (id)
);