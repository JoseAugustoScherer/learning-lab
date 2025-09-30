create table user(
	-- Person class fields
	id int8 auto_increment primary key not null,
	name varchar(255) not null,
	gender_code int8 not null,
	marital_code int8 not null,
	-- User class fields
	gmail varchar(255) not null,
	login varchar(150) not null,
	password varchar(255) not null
	
);

--
-- Seeding user
--

insert into user
	( name, gender_code, marital_code, gmail, login, password )
values
	( 'Administrator', 1, 6, 'admin@gmail.com', 'admin', 'admin12345' ); -- /TODO implement password encryption with PBKDF2, BCrypt, or SCrypt.