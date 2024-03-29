create table Logins (access_date timestamp(6), id bigint not null, user_id bigint, application varchar(255), primary key (id));
create table Users (id bigint not null, FIO varchar(255) not null, USERNAME varchar(255) not null, primary key (id));
