
    create table employees (
       id bigint not null auto_increment,
        email_id varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    ) engine=InnoDB;
