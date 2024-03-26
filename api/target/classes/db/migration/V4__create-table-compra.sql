create table if not exists compra(
id bigint auto_increment ,
valor decimal(10,2),
data_compra datetime,
estabelecimento varchar(255),
categoria varchar(100),
Numero_cartao bigint(16) not null,
Client_id bigint not null,
Cartao_id bigint not null,
primary key(id),
foreign key (Client_id) references bytecard.cliente(id),
foreign key (Cartao_id) references bytecard.cartao(id)


)default charset= utf8mb4;