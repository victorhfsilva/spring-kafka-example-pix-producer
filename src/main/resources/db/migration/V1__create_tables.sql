create table key_table (
    id integer generated by default as identity,
    key_value varchar(255),
    primary key (id)
);

create table pix (
    id integer generated by default as identity,
    pix_value float(53) not null,
    payment_date timestamp(6) not null,
    destiny_key varchar(255) not null,
    identifier varchar(255) not null,
    origin_key varchar(255) not null,
    status varchar(50) not null,
    primary key (id)
);