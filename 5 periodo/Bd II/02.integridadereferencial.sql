
CREATE TABLE CAT(
	IDCAT		INT NOT NULL PRIMARY KEY,
	NOME		VARCHAR(50)	NOT NULL
)

-- INSERT
INSERT INTO CAT (IDCAT, NOME) VALUES (1, 'MAT. INFORM�TICA')
INSERT INTO CAT VALUES (2, 'MAT. EXPEDIENTE')

-- SELECT
SELECT * FROM CAT

-- ALTERA A ORDEM DE APRESENTA��O DOS CAMPOS
SELECT NOME, IDCAT FROM CAT

-- ALTERA O NOME DA COLUNA
SELECT NOME AS NOMECATEGORIA, IDCAT FROM CAT
SELECT NOME    NOMECATEGORIA, IDCAT FROM CAT
SELECT NOME    [NOME DA CATEGORIA], IDCAT FROM CAT
SELECT NOME    'NOME DA CATEGORIA', IDCAT FROM CAT

-- FILTRO
SELECT * FROM CAT WHERE IDCAT = 1

-- ORDENA��O DE DADOS
SELECT * FROM CAT ORDER BY IDCAT DESC

CREATE TABLE PROD(
	IDPROD		INT NOT NULL PRIMARY KEY,
	NOME		VARCHAR(50) NOT NULL,
	IDCAT		INT,
	FOREIGN KEY (IDCAT) REFERENCES CAT
)

-- INSERT
INSERT INTO PROD (IDPROD, NOME, IDCAT) VALUES (1, 'MOUSE', 1)

INSERT INTO PROD VALUES (2, 'TECLADO',  1)
INSERT INTO PROD VALUES (3, 'PAPEL A4', 2)
INSERT INTO PROD VALUES (4, 'R�GUA',    2)

-- ESTE INSERT ACUSA ERRO DE VIOLA��O DE CHAVE ESTRANGEIRA
-- PORQUE EST[A TENTANDO INSERIR UM CATEGORIA QUE N�O EXISTE
INSERT INTO PROD VALUES (5, 'XXXX',    434)

-- TENTATIVA DE EXCLUIR UMA CATEGORIA QUE POSSUI
-- PRODUTOS CADASTRADOS
DELETE FROM CAT WHERE IDCAT = 1

-- TENTATIVA DE ALTERAR O ID 
UPDATE CAT SET IDCAT = 500 WHERE IDCAT = 1

SELECT * FROM CAT
SELECT * FROM PROD

-- ALTERA A TABELA PROD E REMOVE O RELACIONAMENTO
ALTER TABLE PROD DROP CONSTRAINT FK__PROD__IDCAT__33D4B598

-- ALTERA A TABELA PROD E ADICIONA NOVAMENTE O RELACIONAMENTO
-- COM AS OP��ES DE ATUALIZA��O E DE EXCLUS�O
ALTER TABLE PROD
	ADD CONSTRAINT FK_PROD_IDCAT
	FOREIGN KEY (IDCAT) REFERENCES CAT
	ON UPDATE CASCADE ON DELETE CASCADE


SELECT * FROM CAT
SELECT * FROM PROD

-- TENTATIVA DE ALTERA��O DO ID DA CATEGORIA
UPDATE CAT SET IDCAT = 500 WHERE IDCAT = 1

-- TENTATIVA DE EXCLUS�O DA CATEGORIA 500
DELETE FROM CAT WHERE IDCAT	= 500


-- EXCLUS�O DAS TABELAS
DROP TABLE PROD
DROP TABLE CAT
