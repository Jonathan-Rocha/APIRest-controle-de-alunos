create table class_formats(
	
	id bigint not null auto_increment,
	modality varchar(100) not null,
	time_minutes tinyint unsigned not null,
	price smallint unsigned not null,
	user_id bigint not null,
	
	primary key(id),
    foreign key (user_id) references users(id)
	
);