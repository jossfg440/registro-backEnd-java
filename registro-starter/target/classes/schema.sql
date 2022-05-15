drop table if exists CLIENTE;

create table CLIENTE
(
    NOMBRE          VARCHAR(100)  primary key not null,
    EMAIL           VARCHAR(100)                      NOT NULL,
    TELEFONO        VARCHAR(10)                      NOT NULL,
    TIPO_BENEFICIO  VARCHAR(10)                      NOT NULL,
    BENEFICIO       VARCHAR(100)                     NOT NULL
    
);