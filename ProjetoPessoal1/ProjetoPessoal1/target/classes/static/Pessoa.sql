CREATE TABLE PESSOA(
            ID NUMERIC NOT NULL,
            NOME VARCHAR(100) NOT NULL,
            ENDERECO VARCHAR(200) NOT NULL,
            TELEFONE VARCHAR(25) NOT NULL,
            CIDADE VARCHAR(100) NOT NULL
            );

INSERT INTO(ID, NOME, ENDERECO, TELEFONE, CIDADE)
VALUES(1, 'Gabriel Conceição', 'Rua Washington Luis', 19981658363, 'Jaguariúna');

INSERT INTO(ID, NOME, ENDERECO, TELEFONE, CIDADE)
VALUES(2, 'Matheus Silva', 'Avenida Alexandre Marion', 19981062563, 'Jaguariúna');

SELECT * FROM PESSOA;