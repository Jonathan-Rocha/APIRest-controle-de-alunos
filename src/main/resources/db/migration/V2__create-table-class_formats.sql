create table class_formats(
	
	id bigint not null auto_increment,
	modality varchar(100) not null,
	time_minutes varchar(100) not null,
	price decimal(6,2) not null,
	
	primary key(id)
	
);