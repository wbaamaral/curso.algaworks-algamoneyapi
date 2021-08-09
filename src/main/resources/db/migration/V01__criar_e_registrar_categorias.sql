CREATE TABLE `categoria` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) VALUES
	 ('Lazer'),
	 ('Alimentação'),
	 ('Supermercado'),
	 ('Farmácia'),
	 ('Outros');
