create table if not exists cliente(
id bigint auto_increment,
nome varchar(255)not null,
cpf bigint(14) not null unique,
email varchar(100),
telefone bigint(14),

primary key(id)


)default charset= utf8mb4;