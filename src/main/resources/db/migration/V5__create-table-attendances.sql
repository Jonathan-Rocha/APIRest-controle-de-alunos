create table attendances(
	
	id bigint unsigned not null auto_increment,
	attendance boolean not null,
	absence date not null,
	student_id bigint unsigned not null,
	
	primary key(id),
    constraint fk_attendances_student_id foreign key (student_id) references students(id)
	
);