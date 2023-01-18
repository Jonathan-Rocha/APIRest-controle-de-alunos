create table students(
	
	id bigint not null auto_increment,
	name varchar(100) not null,
	instrument_id bigint not null,
	class_format_id bigint not null,
	
	primary key (id),
	foreign key (instrument_id) references instruments(id),
    foreign key (class_format_id) references class_formats(id)
	
);