
--======================================================
-- TIPO DE DADO DEFINIDO PELO USU�RIO
--======================================================
-- PRIMEIRO CRIA O TIPO QUE SER� O PADR�O PARA AS TABELAS
CREATE TYPE USR_NOME_COMPLETO
  FROM VARCHAR(40) NOT NULL

-- QUANDO FOR CRIAR UMA TABELA, AO INV�S DE USAR O TIPO
-- PADR�O DO BANCO DE DADOS, VOC� USA O SEU TIPO CRIADO
CREATE TABLE T01(
	ID		INT,
	NOME	USR_NOME_COMPLETO
)


DROP TABLE T01
DROP TYPE USR_NOME_COMPLETO






