
CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100),
    price NUMERIC(8,2)
);

CREATE TABLE Members (
    member_id INT PRIMARY KEY,
    member_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

CREATE TABLE Issue_Record (
    issue_id INT PRIMARY KEY,
    book_id INT,
    member_id INT,
    issue_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (member_id) REFERENCES Members(member_id)
);

INSERT INTO Books VALUES
(101,'Database System Concepts','Korth','McGraw Hill',650.00),
(102,'Operating System','Galvin','Wiley',750.00),
(103,'Computer Networks','Tanenbaum','Pearson',800.00);

INSERT INTO Members VALUES
(1,'Rahul Sharma','rahul@gmail.com','9876543210'),
(2,'Priya Singh','priya@gmail.com','9876501234'),
(3,'Amit Kumar','amit@gmail.com','9988776655');

INSERT INTO Issue_Record VALUES
(1001,101,1,'2026-07-01','2026-07-15'),
(1002,102,2,'2026-07-02','2026-07-16');

SELECT * FROM BOOKS;
SELECT * FROM MEMBERS
Select * from Issue_Record



SELECT CURRENT_USER

CREATE ROLE LIBRARIAN2 
WITH LOGIN PASSWORD 'Lib@1234'
	   
GRANT SELECT,INSERT,DELETE,UPDATE
ON BOOKS,Members, Issue_Record
TO LIBRARIAN2 


	   
REVOKE SELECT,INSERT,DELETE,UPDATE
ON BOOKS,Members, Issue_Record
FROM LIBRARIAN2 
