

--===============================================================================================
--CRIAR UAM VIEW PARA MOSTRAR O NOME DO PRODUTO, A CATEGORIA QUE ELE PERTENCE E Q QUANTIDADE QUE JA FOI VENDIDA ( de todas as vendas realizadas, n�o filtrar por data).
--===============================================================================================

CREATE VIEW MOSTRAR_PRODUTO
AS
SELECT P.NOMEPRODUTO, C.NOMECATEGORIA, QTDE FROM PRODUTO P
INNER JOIN CATEGORIA C
ON C.IDCATEGORIA = P.IDCATEGORIA
INNER JOIN ITENSVENDA V
ON V.IDPRODUTO = P.IDPRODUTO

SELECT * FROM MOSTRAR_PRODUTO

CREATE VIEW MOSTRAR_PRODUTOS
AS
SELECT P.NOMEPRODUTO, C.NOMECATEGORIA, SUM(QTDE) AS TOTAL_QTDE FROM PRODUTO P
INNER JOIN CATEGORIA C
ON C.IDCATEGORIA = P.IDCATEGORIA
INNER JOIN ITENSVENDA V
ON V.IDPRODUTO = P.IDPRODUTO
GROUP BY P.NOMEPRODUTO, C.NOMECATEGORIA
--ORDER BY SUM(QTDE) DESC (NA VIEW N�O FUNCIONA)

SELECT * FROM MOSTRAR_PRODUTOS
ORDER BY TOTAL_QTDE DESC



--===============================================================================================
--CRIAR UMA TRIGGER SOBRE A TABELA ITENSVENDA PARA QUE TODA VEZ QUE FOR INSERIDO OU ATUALIZADO UM ITEM
--FAZER A ATUALIZA��O DO CAMPO VALORTOTAL NA TABELA VENDA. O VALOR TOTAL DA VENDA � A SOMA DOS TOTAIS DOS ITENS.
--O TOTAL DO ITEM � O PRODUTO DA QUANTIDADE PELO VALOR UNIT�RIO.
--================================================================================================

ALTER TRIGGER TGR_VLRTOTAL
ON ITENSVENDA AFTER INSERT, UPDATE
AS
--VARI�VEIS LOCAIS--
	DECLARE @ID INT
	DECLARE @IDPRODUTO INT
	DECLARE @QTDE INT
	DECLARE @VALORVENDA MONEY
BEGIN
	SELECT @ID = IDVENDA,
	       @IDPRODUTO = IDPRODUTO,
		   @QTDE = QTDE,
		   @VALORVENDA = VALORVENDA FROM inserted

	UPDATE VENDA
	SET VALORTOTAL = @VALORVENDA * @QTDE
	UPDATE VENDA
		SET VALORTOTAL = @VALORVENDA * @QTDE
		WHERE IDVENDA = @ID

	IF EXISTS (SELECT * FROM inserted) AND
	   EXISTS (SELECT * FROM deleted) 
	BEGIN
		UPDATE VENDA
		SET VALORTOTAL = @VALORVENDA * @QTDE
		WHERE IDVENDA = @ID
	END
	
	

END
 


SELECT * FROM ITENSVENDA
SELECT * FROM VENDA

UPDATE ITENSVENDA
SET VALORVENDA = 10 WHERE IDVENDA = 2