CREATE SCHEMA rl_api_users;

SET search_path TO rl_api_users;

CREATE TABLE rl_api_users.rl_user_role (
    id_rl_user_role SERIAL PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE rl_api_users.rl_user (
    id_rl_user SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    id_rl_user_role INTEGER NOT NULL,
    CONSTRAINT fk_rl_user_role FOREIGN KEY (id_rl_user_role)
    REFERENCES rl_api_users.rl_user_role (id_rl_user_role)
);

insert into
  rl_api_users.rl_user_role (
    descripcion
  )
values
  (
    'user'
  );