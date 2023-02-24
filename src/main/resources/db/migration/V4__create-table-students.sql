create table students(
	
	id bigint unsigned not null auto_increment,
	name varchar(100) not null,
	days_of_week tinyint unsigned not null,
	instrument_id bigint unsigned not null,
	class_format_id bigint unsigned not null,
	user_id bigint unsigned not null,
	
	primary key (id),
	constraint fk_students_instrument_id foreign key (instrument_id) references instruments(id),
    constraint fk_students_class_format_id foreign key (class_format_id) references class_formats(id),
    constraint fk_students_user_id foreign key (user_id) references users(id)
	
);