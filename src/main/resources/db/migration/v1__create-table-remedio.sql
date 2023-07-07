create table remedio(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    via varchar(255) not null,
    lote varchar(255) not null,
    quantidade int (20) not null,
    validade varchar(255) not null,
    laboratorio varchar(255) not null,

    primary key(id)
)