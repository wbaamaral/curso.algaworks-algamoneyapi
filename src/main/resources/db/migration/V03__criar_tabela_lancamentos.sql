CREATE TABLE `lancamento` (
  `codigo` bigint(20) AUTO_INCREMENT PRIMARY KEY,
  `descricao` varchar(100) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `observacao` VARCHAR(100),
  `data_vencimento` DATE NOT NULL,
  `data_pagamento` DATE,
  `valor` DECIMAL(19,4) NOT NULL,
  `codigo_categoria` bigint(20) not null,
  `codigo_pessoa` bigint(20) not null,
  CONSTRAINT lancamento_FK 
  FOREIGN KEY (codigo_categoria) 
  	REFERENCES algamoneyapi.categoria(codigo), 
    -- ON DELETE CASCADE ON UPDATE CASCADE ,
  CONSTRAINT pessoa_FK
  FOREIGN KEY (codigo_pessoa)
  REFERENCES algamoneyapi.pessoa(codigo)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_croatian_ci
AUTO_INCREMENT=1;
