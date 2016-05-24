
CRIAR UMA TRIGGER SOBRE A TABELA ITENSVENDA
PARA QUE QUANDO FOR INSERIDA UM ITEM DA VENDA
VERIFICAR SE H� A QUANTIDADE EM ESTOQUE SUFICIENTE
PARA VENDER. SE N�O HOUVER, EMITIR UMA MENSAGEM
DE ERRO E CANCELAR A TRANSA��O. SE HOUVER, DEIXAR
CONFIRMAR A VENDA DO ITEM.






ALTER TRIGGER TRG_ITENSVENDA_INSERT
	ON ITENSVENDA AFTER INSERT
AS
	-- VARI�VEIS LOCAIS
	DECLARE @IDV	INT
	DECLARE @IDP	INT
	DECLARE @QTD	INT
	DECLARE @QTDPROD	INT
	DECLARE @VLVENDA MONEY
BEGIN
	-- DADOS INSERIDOS NA TABELA ITENSVENDA
	--SET @IDV = (SELECT IDVENDA   FROM INSERTED)
	--SET @IDP = (SELECT IDPRODUTO FROM INSERTED)
	--SET @QTD = (SELECT QTDE      FROM INSERTED)

	SELECT  @IDV = IDVENDA,
			@IDP = IDPRODUTO,
			@QTD = QTDE      FROM INSERTED
			

	-- SELECIONA A QUANTIDADE EM ESTOQUE DO
	-- PRODUTO QUE EST� SENDO VENDIDO
	SET @QTDPROD = (SELECT QTDEESTOQUE
					  FROM PRODUTO
					 WHERE IDPRODUTO = @IDP)
	
	IF (@QTDPROD < @QTD)
	BEGIN
		PRINT 'N�O PODE VENDER ESTA QUANTIDADE'
		PRINT 'N�O TEM ESTOQUE SUFICIENTE'
		PRINT 'QTDE DISPONIVEL: ' +
				CAST(@QTDPROD AS VARCHAR)
		ROLLBACK
	END
	ELSE
	BEGIN
		-- DAR A BAIXA DO PRODUTO NO ESTOQUE
		UPDATE PRODUTO
		   SET QTDEESTOQUE = QTDEESTOQUE - @QTD
		 WHERE IDPRODUTO   = @IDP

		 --SELECIONA O VALOR DE VENDA DO PRODUTO
		 SET @VLVENDA = (SELECT VALORUNITARIO
						 FROM PRODUTO
						 WHERE IDPRODUTO = @IDP)
		-- ATUALIZA A TABELA ITENSVENDA
		UPDATE ITENSVENDA
		   SET VALORVENDA = @VLVENDA
		 WHERE IDVENDA    = @IDV
		   AND IDPRODUTO  = @IDP
	END
END
GO

-- EXECU��O DA INSER��O PARA DISPARAR A TRIGGER

INSERT INTO ITENSVENDA
	 (IDVENDA, IDPRODUTO, QTDE, VALORVENDA)
  VALUES (4, 1, 9, 9000000)
	









