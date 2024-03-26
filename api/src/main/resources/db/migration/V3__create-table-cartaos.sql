create table if not exists Cartao(
id bigint auto_increment,
numero_cartao bigint(16) not null unique,
validade date,
cvv int(3),
limite decimal(10,2),
status boolean,
cpf_client varchar(20) not null ,
id_cliente bigint not null,
primary key(id),
foreign key(id_cliente) references bytecard.cliente(id)


)default charset= utf8mb4;