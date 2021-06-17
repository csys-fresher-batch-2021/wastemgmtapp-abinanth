create table recidencytype(
recidency_id  serial primary key,
	recidency_type varchar(100) not null,
	recidency_no varchar(100) not null,
	street_name varchar(100) not null,
	city_name varchar(100) not null,
	district_name varchar(100) not null,
	years varchar(10) not null,
	unique(recidency_no,street_name,city_name,district_name)
);
create table recidency(
recidency_id serial primary key,
	recidencies varchar(100) not null unique
);
create table payment(
	user_name varchar(100) not null,
	recidency_no int not null,
	recidency_type varchar(100) not null,
	amount decimal not null,
	status varchar(100) not null,
	payment_id  serial primary key,
	due_date date not null,
	fine_amount decimal ,
	paid_date date ,
	total_amount decimal,
	unique(recidency_no)
	
);