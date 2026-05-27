CREATE DATABASE IF NOT EXISTS cad_cliente;
USE cad_cliente;

CREATE TABLE IF NOT EXISTS cad_cli (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    nome_da_mae VARCHAR(100) NOT NULL,
    nome_do_pai VARCHAR(100) NULL,
    CPF CHAR(12) NOT NULL,
    data_nascimento VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    CEP CHAR(12) NOT NULL
);