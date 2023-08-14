
-- Deleta todos os dados assim que iniciar o projeto
DELETE FROM ADMINISTRADOR;
DELETE FROM ALUNO;
DELETE FROM PROFESSOR;
DELETE FROM COORDENADOR;
DELETE FROM USUARIO;
DELETE FROM MATRIZ_CURRICULAR;
DELETE FROM DISCIPLINA;

-- Faz com que todos os id comecem a contagem do número 1
ALTER TABLE ADMINISTRADOR AUTO_INCREMENT = 1;
ALTER TABLE ALUNO AUTO_INCREMENT = 1;
ALTER TABLE PROFESSOR AUTO_INCREMENT = 1;
ALTER TABLE COORDENADOR AUTO_INCREMENT = 1;
ALTER TABLE USUARIO AUTO_INCREMENT = 1;
ALTER TABLE MATRIZ_CURRICULAR AUTO_INCREMENT = 1;
ALTER TABLE DISCIPLINA AUTO_INCREMENT = 1;


-- Adiciona os dados as tabelas
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (10, 'Física', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Química', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Cálculo', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Física 2', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Cálculo 2', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Biologia', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Anatomia', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Cardiologia', 1);
INSERT INTO DISCIPLINA(horas, nome, semestre) VALUES (15, 'Pediatria', 1);

INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia de Software', 1);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia de Software', 2);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia de Software', 3);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia de Software', 4);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Engenharia de Software', 5);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Medicina', 6);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Medicina', 7);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Medicina', 8);
INSERT INTO MATRIZ_CURRICULAR(curso, disciplina_id) VALUES ('Medicina', 9);

INSERT INTO ADMINISTRADOR(nome, matricula, tipo_de_usuario) VALUES ('Administrador', 12345, 'ADMINISTRADOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario) VALUES ('Administrador', 12345, 'admin', 'admin', 'ADMINISTRADOR');

INSERT INTO ALUNO(nome, matricula, curso, tipo_de_usuario, matriz_curricular_id) VALUES ('Alice Silva', 12335, 'Medicina', 'ALUNO', 1);
INSERT INTO ALUNO(nome, matricula, curso, tipo_de_usuario, matriz_curricular_id) VALUES ('Pedro Souza', 67890, 'Engenharia de Software', 'ALUNO', 2);
INSERT INTO ALUNO(nome, matricula, curso, tipo_de_usuario, matriz_curricular_id) VALUES ('Mariana Santos', 54321, 'Medicina', 'ALUNO', 1);
INSERT INTO ALUNO(nome, matricula, curso, tipo_de_usuario, matriz_curricular_id) VALUES ('Lucas Oliveira', 98765, 'Engenharia de Software', 'ALUNO', 2);
INSERT INTO ALUNO(nome, matricula, curso, tipo_de_usuario, matriz_curricular_id) VALUES ('Isabella Costa', 23456, 'Medicina', 'ALUNO', 1);
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario) VALUES ('Alice Silva', 12335, 'alice123', '123', 'ALUNO');
INSERT INTO USUARIO (nome, matricula, login, senha, tipo_de_usuario) VALUES ('Pedro Souza', 67890, 'pedro123', '123', 'ALUNO');
INSERT INTO USUARIO (nome, matricula, login, senha, tipo_de_usuario) VALUES ('Mariana Santos', 54321, 'mariana123', '123', 'ALUNO');
INSERT INTO USUARIO (nome, matricula, login, senha, tipo_de_usuario) VALUES ('Lucas Oliveira', 98765, 'lucas123', '123', 'ALUNO');
INSERT INTO USUARIO (nome, matricula, login, senha, tipo_de_usuario) VALUES ('Isabella Costa', 23456, 'isabella123', '123', 'ALUNO');


INSERT INTO PROFESSOR(nome, matricula, tipo_de_usuario, matriz_curricular_id) VALUES ('Carlos Pereira', 111, 'PROFESSOR', 1);
INSERT INTO PROFESSOR(nome, matricula, tipo_de_usuario, matriz_curricular_id) VALUES ('Ana Rodrigues', 222, 'PROFESSOR', 2);
INSERT INTO PROFESSOR(nome, matricula, tipo_de_usuario, matriz_curricular_id) VALUES ('Ricardo Almeida', 333, 'PROFESSOR', 1);
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario)VALUES ('Carlos Pereira', 111, 'carlos123', '123', 'PROFESSOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario)VALUES ('Ana Rodrigues', 222, 'ana123', '123', 'PROFESSOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario)VALUES ('Ricardo Almeida', 333, 'ricardo123', '123', 'PROFESSOR');


INSERT INTO COORDENADOR(nome, matricula, curso_coordenado, tipo_de_usuario) VALUES ('Maria Fernandes', 4444, 'Engenharia de Software', 'COORDENADOR');
INSERT INTO COORDENADOR(nome, matricula, curso_coordenado, tipo_de_usuario) VALUES ('Paulo Costa', 5555, 'Medicina', 'COORDENADOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario) VALUES ('Maria Fernandes', 4444, 'maria123', '123', 'COORDENADOR');
INSERT INTO USUARIO(nome, matricula, login, senha, tipo_de_usuario) VALUES ('Paulo Costa', 5555, 'paulo123', '123', 'COORDENADOR');






