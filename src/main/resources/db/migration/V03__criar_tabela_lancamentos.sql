CREATE TABLE `lancamento` (
  `codigo` bigint(20) AUTO_INCREMENT PRIMARY KEY,
  `descricao` varchar(100) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `dataVencimento` DATETIME,
  `dataPagamento` DATETIME,
  `valor` DECIMAL(19,4) NOT NULL,
  `categoria_id` bigint(20) not null,
  `pessoa_id` bigint(20) not null,
  CONSTRAINT lancamento_FK 
  FOREIGN KEY (categoria_id) 
  	REFERENCES algamoneyapi.categoria(codigo), 
--  		ON DELETE CASCADE ON UPDATE CASCADE ,
  CONSTRAINT pessoa_FK
  FOREIGN KEY (pessoa_id)
    REFERENCES algamoneyapi.pessoa(codigo)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_croatian_ci
AUTO_INCREMENT=1;
