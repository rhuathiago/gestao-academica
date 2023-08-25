DROP TABLE IF EXISTS administrador;
DROP TABLE IF EXISTS aluno;
DROP TABLE IF EXISTS coordenador;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS disciplina;
DROP TABLE IF EXISTS matriz_curricular;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS usuario;

CREATE TABLE administrador (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula INT,
    nome VARCHAR(255),
    tipo_de_usuario VARCHAR(255)
);

CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    curso VARCHAR(255),
    matricula INT,
    nome VARCHAR(255),
    tipo_de_usuario VARCHAR(255)
);

CREATE TABLE coordenador (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula INT,
    nome VARCHAR(255),
    tipo_de_usuario VARCHAR(255)
);

CREATE TABLE professor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    curso VARCHAR(255),
    matricula INT,
    nome VARCHAR(255),
    tipo_de_usuario VARCHAR(255)
);

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255),
    matricula INT,
    nome VARCHAR(255),
    senha VARCHAR(255),
    tipo_de_usuario VARCHAR(255),
    curso VARCHAR(255)
);

CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE disciplina (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    horas INT,
    nome VARCHAR(255),
    semestre INT
);

CREATE TABLE matriz_curricular (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    curso VARCHAR(255),
    disciplina_id BIGINT
);

INSERT INTO CURSO(nome) VALUES ('Engenharia Civil');
INSERT INTO CURSO(nome) VALUES ('Medicina');

INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (80, 'Física', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (90, 'Química', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (120, 'Cálculo', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (95, 'Biologia Molecular', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (130, 'Morfologia Médica', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (150, 'Patologia', 1);

INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia Civil', 1);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia Civil', 2);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia Civil', 3);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Medicina', 4);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Medicina', 5);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Medicina', 6);

INSERT INTO ADMINISTRADOR(nome, matricula, tipo_de_usuario) VALUES ('Administrador', 8234567, 'ADMINISTRADOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario, curso) VALUES (
    'Administrador', 8234567, 'admin', '$2a$10$kKdKXfgm9VLdyi2qs8mqyuL5WjFD3ww6nCXwrryH6B5.k3XuVxEc6', 'ADMINISTRADOR', ''
);

INSERT INTO ALUNO(nome, matricula, curso, tipo_de_usuario) VALUES ('Aluno', 9876543, 'Medicina', 'ALUNO');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario, curso) VALUES (
    'Aluno', 9876543, 'aluno', '$2a$10$kKdKXfgm9VLdyi2qs8mqyuL5WjFD3ww6nCXwrryH6B5.k3XuVxEc6', 'ALUNO', 'Medicina'
);

INSERT INTO ALUNO(nome, matricula, curso, tipo_de_usuario) VALUES ('Aluno2', 9876343, 'Engenharia Civil', 'ALUNO');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario, curso) VALUES (
    'Aluno2', 9876343, 'aluno2', '$2a$10$kKdKXfgm9VLdyi2qs8mqyuL5WjFD3ww6nCXwrryH6B5.k3XuVxEc6', 'ALUNO', 'Engenharia Civil'
);

INSERT INTO PROFESSOR(nome, curso, matricula, tipo_de_usuario) VALUES ('Professor', 'Medicina', 4567890, 'PROFESSOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario, curso)VALUES (
    'Professor', 4567890, 'prof', '$2a$10$kKdKXfgm9VLdyi2qs8mqyuL5WjFD3ww6nCXwrryH6B5.k3XuVxEc6', 'PROFESSOR', 'Medicina'
);

INSERT INTO COORDENADOR(nome, matricula, tipo_de_usuario) VALUES ('Coordenador', 2345678, 'COORDENADOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario, curso) VALUES (
    'Coordenador', 2345678, 'coord', '$2a$10$kKdKXfgm9VLdyi2qs8mqyuL5WjFD3ww6nCXwrryH6B5.k3XuVxEc6', 'COORDENADOR', ''
);






