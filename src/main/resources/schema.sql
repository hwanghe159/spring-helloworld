create table user(
    id bigint auto_increment,
    name varchar(255) not null,
    create_at datetime,
    update_at datetime,
    primary key(id)
);

create table article(
    id bigint auto_increment primary key,
    title varchar(255) not null,
    content varchar(255) not null
);

create table author(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

create table article_author(
    article bigint not null,
    author bigint not null
);

create table comment(
    article bigint not null,
    content varchar(255) not null
);
