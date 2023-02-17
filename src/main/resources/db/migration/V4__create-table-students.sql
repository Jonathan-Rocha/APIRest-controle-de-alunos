create table students(
	
	id bigint unsigned not null auto_increment,
	name varchar(100) not null,
	instrument_id bigint unsigned not null,
	class_format_id bigint unsigned not null,
	user_id bigint unsigned not null,
	
	primary key (id),
	foreign key (instrument_id) references instruments(id),
    foreign key (class_format_id) references class_formats(id),
    foreign key (user_id) references users(id)
	
);