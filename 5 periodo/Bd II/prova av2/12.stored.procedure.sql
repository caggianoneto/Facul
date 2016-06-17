



--===========================================
-- STORED PROCEDURE - PROCEDIMENTO ARMAZENADO
--===========================================
� UM PROCEDIMENTO QUE � EXECUTADO DIRETAMENTE
NO BANCO DE DADOS
	. PODE N�O RETORNAR VALOR
	. PODER RETORNAR SOMENTE UM VALOR
	. PODE RETORNAR MAIS DE UM VALOR
	. PODE N�O RECEBER VALOR
	. PODE RECEBER SOMENTE UM VALOR
	. PODE RECEBER MAIS DE UM VALOR
	. DIFERE DE UMA FUN��O PORQUE UMA SP PODE
		RETORNAR MAIS DE UM VALOR
	. DIFERE DE UMA TRIGGER PORQUE UMA SP PODE
		SER EXECUTADA A QUALQUER MOMENTO OU
		AINDA NEM SER INVOCADA.
	. UMA SP PODE EXECUTAR TAREFAS DE CRUD EM TABELAS
		C - CREATE (INSERT)
		R - RETRIEVE / READ (SELECT)
		U - UPDATE (UPDATE)
		D - DELETE (DELETE)

--======================================
-- STORED PROCEDURE QUE RETORNA O TOTAL
-- DE PRODUTOS CADASTRADOS
--======================================
CREATE PROCEDURE SP_TOTAL_PRODUTOS
	@TOTAL	INT OUTPUT
AS
	SET @TOTAL = (SELECT COUNT(*) FROM PRODUTO)
GO

-- EXECU��O DESTA PROCEDURE
-- DECLARA A VARI�VEL QUE VAI RECEBER O RETORNO DA SP
DECLARE @TOTAL_PROD INT

EXEC SP_TOTAL_PRODUTOS @TOTAL_PROD OUTPUT

-- IMPRESS�O DO RESULTADO
PRINT @TOTAL_PROD
PRINT 'TOTAL DE PRODUTOS: ' +
	 CAST(@TOTAL_PROD AS VARCHAR)

--===================================================
-- SP PARA RECEBER DUAS DATAS (INI E FIM) E
-- DEVOLVER O VALOR TOTAL DE VENDAS ENTRE ESTAS DATAS
--===================================================
CREATE PROCEDURE SP_TOTAL_VENDAS_ENTRE_DATAS
	@DATAINI	DATE,
	@DATAFIM	DATE,
	@TOTAL		MONEY OUTPUT
AS
	SET @TOTAL = (
		SELECT SUM(QTDE * VALORVENDA)
		  FROM ITENSVENDA IV
		 INNER JOIN VENDA V ON V.IDVENDA = IV.IDVENDA
		 WHERE V.DATAHORA BETWEEN
			 @DATAINI AND @DATAFIM)
GO


-- EXECU��O DESTA SP
DECLARE @TOTALVENDAS	MONEY

exec SP_TOTAL_VENDAS_ENTRE_DATAS 
	'20140801', '20140831', @TOTALVENDAS OUTPUT

PRINT 'TOTAL DE VENDAS: ' +
	CAST(@TOTALVENDAS AS VARCHAR)

--===================================================
-- MONTAR UMA SP PARA RECEBER DUAS DATAS E RETORNAR
-- A QUANTIDADE DE PRODUTOS VENDIDOS NESTE PER�ODO
--===================================================




-- SP PARA MOSTRAR O SCRIPT DE CRIA��O DE
-- UM SP, TRIGGER, ETC
exec sp_helptext SP_TOTAL_VENDAS_ENTRE_DATAS



