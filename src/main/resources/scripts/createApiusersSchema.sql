create schema rl_api_users;
set search_path to rl_api_users;

create table rl_api_users.rl_user_role
(
    id_rl_user_role serial
        primary key,
    descripcion         varchar(100) not null
);

create table rl_api_users.rl_user
(
    id_rl_user      serial
        primary key,
    username            varchar(100) not null,
    user_password       varchar(100) not null,
    id_system_user_role integer      not null
        references public.system_user_role
);
