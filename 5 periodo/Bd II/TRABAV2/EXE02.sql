CREATE TRIGGER TRG_EMPRESTAR
	ON EXEMPLAR AFTER INSERT, UPDATE
AS
BEGIN
	DECLARE
	@SITUACAO CHAR
	SELECT @SITUACAO = SITUACAO FROM inserted
	IF (@SITUACAO = 'L')
	UPDATE EXEMPLAR
	SET SITUACAO = @SITUACAO
	ELSE
	ROLLBACK
END