use algamoneyapi;

CREATE TABLE pessoa (
	codigo BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	logradouro varchar(100) NULL,
	numero varchar(10) NULL,
	complemento varchar(40) NULL,
	bairro varchar(30) NULL,
	cep varchar(14) NULL,
	cidade varchar(50) NULL,
	estado varchar(2) NULL,
	ativo boolean NOT NULL,
	PRIMARY KEY (codigo)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_croatian_ci
AUTO_INCREMENT=1;



CREATE FULLTEXT INDEX pessoa_nome_IDX ON pessoa (nome);
CREATE INDEX pessoa_codigo_IDX USING BTREE ON pessoa (codigo);


INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo) VALUES
	 ('Natália Sophia Maria Costa','76909-842','Rua Governador Jorge Teixeira',866,'Habitar Brasil','Ji-Paraná','RO', true),
	 ('Simone Gabriela Ramos','76811-204','Rua Banzo',144,'Castanheira','Porto Velho','RO', true),
	 ('Elza Laís Priscila Corte Real','76873-738','Rua Francisco Xavier',996,'Colonial','Ariquemes','RO', true),
	 ('Marcos José Sérgio Pereira','76875-576','Rua Florata',145,'Residencial Gerson Neco','Ariquemes','RO', true),
	 ('Valentina Evelyn Aragão','76907-492','Rua João F. de Almeida',483,'Jardim Aurélio Bernardi','Ji-Paraná','RO', true),
	 ('Levi Diogo Souza','76873-634','Rua Osvaldo de Andrade',981,'Setor 06','Ariquemes','RO', false),
	 ('Rafael Rodrigo Gael Drumond','76901-199','Rua das Rosas',970,'Santiago','Ji-Paraná','RO', true),
	 ('Luan Roberto Filipe da Rosa','76960-262','Rua Bom Jardim',799,'Sociedade Bela Vista','Cacoal','RO', true),
	 ('Sophia Mirella Campos','76811-206','Rua São Bento',343,'Castanheira','Porto Velho','RO', true),
	 ('Laís Marina Lopes','76824-054','Rua do Ouro',977,'Aponiã','Porto Velho','RO', true);
INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo) VALUES
     ('Elias Noah dos Santos','76907-480','Rua Pedro Gurgacz',356,'Jardim Aurélio Bernardi','Ji-Paraná','RO', true),
	 ('Ester Valentina Jéssica Baptista','76913-605','Rua Vinícius de Moraes',335,'São Pedro','Ji-Paraná','RO', false),
	 ('Sarah Sophie Eliane Monteiro','76907-250','Rua Vitória Régia',871,'Novo Horizonte','Ji-Paraná','RO', true),
	 ('Levi Augusto Benedito Monteiro','76870-550','Rua Paraná',825,'Setor 05','Ariquemes','RO', true),
	 ('Nicolas Lorenzo Ryan Castro','76806-134','Rua Pavine',747,'Floresta','Porto Velho','RO', true),
	 ('Anthony Enrico Farias','76876-460','Avenida Girassol',978,'Pedras','Ariquemes','RO', true),
	 ('Andrea Rita Jesus','76813-502','Rua Itatiaia',723,'Mariana','Porto Velho','RO', true),
	 ('Josefa Sebastiana Laura Silveira','76803-749','Rua Abunã',973,'São João Bosco','Porto Velho','RO', false),
	 ('Vera Elisa Maitê Barros','76908-608','Rua Antônio Serpa do Amaral',576,'Nova Brasília','Ji-Paraná','RO', true),
	 ('Larissa Cristiane Silva','76870-218','Rua Piquira',118,'Áreas Especiais','Ariquemes','RO', true);
INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo) VALUES
	 ('Clara Heloisa Gomes','76811-818','Rua Freijó',409,'Eldorado','Porto Velho','RO', true),
	 ('Isabella Sabrina Caldeira','76907-167','Rua Unaí',447,'Park Amazonas','Ji-Paraná','RO', true),
	 ('Davi Benício Aparício','76901-644','Rua Gralha Azul',329,'Milão','Ji-Paraná','RO', true),
	 ('Rosângela Eloá da Rocha','76876-334','Rua Lajes',558,'Setor 09','Ariquemes','RO', true),
	 ('Eduardo Kauê César Galvão','76967-468','Rua Mato Grosso',930,'Liberdade','Cacoal','RO', false),
	 ('Marli Mariana Antonella Rocha','76873-770','Rua Beira Rio',164,'Setor 11','Ariquemes','RO', true),
	 ('Rebeca Débora Marlene Cardoso','76877-006','Rua Marçal Coceiro de Almeida',741,'Marechal Rondon 01','Ariquemes','RO', true),
	 ('Sebastião Luís dos Santos','76870-198','Rodovia BR-364',474,'Apoio BR-364','Ariquemes','RO', true),
	 ('Tiago Cauê Monteiro','76876-080','Rua Porto Rico',679,'Setor 10','Ariquemes','RO', true),
	 ('Jorge Sérgio Otávio Costa','76828-618','Rua Pirinópolis',636,'Jardim Santana','Porto Velho','RO', true);
