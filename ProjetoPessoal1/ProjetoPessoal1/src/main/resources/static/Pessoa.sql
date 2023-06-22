CREATE TABLE PESSOA(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            NOME VARCHAR(100) NOT NULL,
            ENDERECO VARCHAR(200) NOT NULL,
            TELEFONE VARCHAR(100) NOT NULL
            );

INSERT INTO pessoa (nome, endereco, telefone) VALUES
('Maria', 'Nazaré', '12345678'),
('José', 'Galileia', '2345678'),
('Pedro', 'Samaria', '3454657');

SELECT * FROM PESSOA;