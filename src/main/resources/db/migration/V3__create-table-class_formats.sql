create table class_formats(
	
	id bigint unsigned not null auto_increment,
	modality varchar(100) not null,
	time_minutes tinyint unsigned not null,
	price smallint unsigned not null,
	user_id bigint unsigned not null,
	
	primary key(id),
    constraint fk_class_formats_user_id foreign key (user_id) references users(id)
	
);