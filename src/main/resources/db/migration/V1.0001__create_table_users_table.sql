CREATE TABLE IF NOT EXISTS "users_table"
(
    id                bigserial    NOT NULL PRIMARY KEY,
    name              VARCHAR(30)  DEFAULT 'John',
    surname           VARCHAR(30)  DEFAULT 'Doe',
    password          VARCHAR(100) NOT NULL,
    phone_number      VARCHAR(9)   DEFAULT '000000000',
    email             VARCHAR(255) NOT NULL,
    enabled           BOOLEAN      DEFAULT true,
    verification_link VARCHAR(255) DEFAULT NULL,
    is_verified       BOOLEAN      DEFAULT false,
    role              VARCHAR(255) DEFAULT 'REGULAR',
    CONSTRAINT name_length CHECK (LENGTH(name) <= 30),
    CONSTRAINT surname_length CHECK (LENGTH(surname) <= 30),
    CONSTRAINT password_length CHECK (LENGTH(password) >= 5 AND LENGTH(password) <= 100),
    CONSTRAINT phone_number_length CHECK (LENGTH(phone_number) = 9),
    CONSTRAINT role_check CHECK (role in ('REGULAR', 'ADMIN', 'OFFICIAL'))
)
