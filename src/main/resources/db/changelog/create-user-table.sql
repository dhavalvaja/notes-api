--liquibase formatted sql

--changeset dhaval:create-user-table
CREATE TABLE public.users(
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)
GO
