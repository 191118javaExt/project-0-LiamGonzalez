--SCHEMA project0;



------------------------------------------------------------------------------------------------------------------------

drop table if exists customers CASCADE;
drop table if exists employeesAdmins CASCADE;
drop table if exists bankAccounts CASCADE;
drop table if exists transactions CASCADE;

--maybe remove project0. from customers
create TABLE customers (
	userName VARCHAR (50) PRIMARY KEY UNIQUE,  --50 to 40 
	userPassword varchar (50) NOT NULL,
	firstName varchar (50) NOT NULL,
	lastName varchar (50) NOT NULL,
	approved boolean NOT NULL
);



create table employeesAdmins (
	userName VARCHAR (50) PRIMARY KEY,  --50 to 40
	userPassword varchar (50) NOT NULL,
	firstName varchar (50) NOT NULL,
	lastName varchar (50) NOT NULL,
	isAdmin boolean NOT NULL
);

---------------------------------
create table bankAccounts (
	--accountnumber int PRIMARY KEY,
	accountNumber serial PRIMARY KEY,
	accountBalance numeric (50, 2) DEFAULT 0,
	userNam varchar (50) NOT NULL REFERENCES customers(userName)
);


create table transactions (
	transactionID serial PRIMARY KEY,
	timeoccur VARCHAR (75),
	accountNum int NOT NULL REFERENCES bankAccounts(accountNumber),
	descript VARCHAR (50) NOT NULL
);

ALTER SEQUENCE bankaccounts_accountnumber_seq RESTART WITH 1000000000 INCREMENT BY 10; --???


-- function 
CREATE  OR  REPLACE FUNCTION recentTransactions(acctNo int) RETURNS SETOF transactions
AS 
$$
	select * from project0.transactions where accountnum = acctNo      
		order by timeoccur desc
		limit 3;
$$ LANGUAGE SQL;
--do anything to project0.transactions?
INSERT into customers (userName, userPassword, firstName, lastName, approved) 
	VALUES ('test1','Test2','test3','test4', TRUE );


--is this needed
SELECT * FROM transactions;


INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('UserName', 'Password1', 'Liam', 'Gonzalez', TRUE);

INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('Employee1', 'Password1', 'Gunther', 'Rosenthal', FALSE);

INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('Employee2', 'Password1', 'Andrew', 'Miller', FALSE );

INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('CJohnson', '12345', 'Chris', 'Johnson', TRUE );

INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('JBarrett', 'GeorgeMason', 'Jocelyn', 'Barrett', TRUE );

INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('WISH', 'JMeija', 'Jorge', 'Meija', TRUE );

INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('school', '98765', 'Tim', 'Gattie', FALSE );

INSERT INTO employeesAdmins (userName, userPassword, firstName, lastName, isAdmin)
	VALUES ('username123', 'Password123', 'firstname', 'lastname', TRUE);

------------------------------------------------------------------------------------------------
INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES (34.55, 'username123');

INSERT INTO bankAccounts (accountBalance, userNam)
	values(8373.33, 'username123');

--INSERT INTO bankAccounts (accountBalance, userNam)
	--VALUES(992.86, 'JBarrett');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES(80.01, 'Test2');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES(39.09, 'WISH');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES(125.67, 'Employee1');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES (653.44, 'Employee1');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES(90.05, 'Employee2');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES(11178.01, 'Employee2');

insert into bankAccounts (accountBalance, userNam)
	values(3476.73, 'Employee2');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES(33449.94, 'Employee2');

INSERT INTO bankAccounts (accountBalance, userNam)
	VALUES(12345.67, 'practice');


--may need to delete these two things...
SELECT * FROM customers;
SELECT * FROM bankAccounts;

--SELECT * FROM employeesAdmins, bankAccounts WHERE userName = usernam;


INSERT INTO employeesadmins (userName, userPassword, firstName, lastName, isadmin)
	VALUES ('adminuser', 'adminPassword1', 'admin', 'istrator', TRUE);

SELECT * FROM employeesadmins;

INSERT into customers (userName, userPassword, firstName, lastName, approved)
	VALUES ('username123', 'Password123', 'first', 'last', TRUE);

SELECT * FROM customers;
-----

SELECT * FROM customers WHERE username = 'username123';