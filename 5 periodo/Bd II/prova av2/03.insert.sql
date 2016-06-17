
INSERT INTO CATEGORIA (NOMECATEGORIA) VALUES ('MAT. INFORM�TICA')
INSERT INTO CATEGORIA VALUES ('MAT. EXPEDIENTE')

-- OUTRA FORMA DE INSERIR
-- INSERT INTO CATEGORIA VALUES ('MAT. INFORM�TICA'), ('MAT. EXPEDIENTE')

SELECT * FROM CATEGORIA

INSERT INTO CLIENTE
	(NOMECLIENTE, CPFCNPJ, DATANASC, ENDERECO, CIDADE, ESTADO)
	VALUES
		('CHICO BENTO', '12345678909', '1980-05-03',
			'RUA A', 'CURITIBA', 'PR'),
		('CASC�O', '98765432101', '1981-06-05',
			'RUA B', 'CURITIBA','PR'),
		('M�NICA', '65432198798', '1979-06-02',
		'RUA C', 'CURITIBA', 'PR')
	

SELECT * FROM CLIENTE

DELETE FROM CLIENTE WHERE IDCLIENTE = 3
					   OR IDCLIENTE = 4
					   OR IDCLIENTE = 5

SELECT * -- DELETE
  FROM CLIENTE
 WHERE IDCLIENTE IN (1,2,3)


-- INSERE UM REGISTRO, POR�M FICA COM ID N�O SEQUENCIAL
INSERT INTO CLIENTE (NOMECLIENTE, CPFCNPJ) VALUES
		('Z� LEL�', '78998745665')	

SELECT * FROM CLIENTE

-- EXCLUI OS REGISTROS
DELETE CLIENTE WHERE IDCLIENTE IN (6,7)

-- ALTERA A SEMENTE DO CAMPO AUTOINCREMENT�VEL PARA 2
DBCC CHECKIDENT ('CLIENTE', RESEED, 2)

-- INSERE OS REGISTROS NOVAMENTE
INSERT INTO CLIENTE
	(NOMECLIENTE, CPFCNPJ, DATANASC, ENDERECO, CIDADE, ESTADO)
	VALUES
		('M�NICA', '65432198798', '1979-06-02',
		'RUA C', 'CURITIBA', 'PR')

INSERT INTO CLIENTE
	(NOMECLIENTE, CPFCNPJ, DATANASC, ENDERECO, CIDADE, ESTADO)
	VALUES
		('Z� LEL�', '98765435458', '1981-09-12',
		'RUA A', 'PINHAIS', 'PR')

SELECT * FROM CLIENTE