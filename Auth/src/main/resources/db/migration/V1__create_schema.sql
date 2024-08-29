CREATE TABLE "users"
(
    "id"       SERIAL,
    "username" VARCHAR(255) NOT NULL,
    "name"     TEXT         NOT NULL,
    "password" TEXT         NOT NULL,
    "roles"    VARCHAR(255) NOT NULL,
    PRIMARY KEY ("id"),
    UNIQUE ("username")
);