DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  birthDate VARCHAR(250) DEFAULT NULL,
  JMBAG VARCHAR(10) NOT NULL,
  ECTSCount INT NOT NULL
);

CREATE TABLE Course (
 id INT AUTO_INCREMENT  PRIMARY KEY,
 name VARCHAR(250) NOT NULL,
 ECTS INT NOT NULL,
 semester VARCHAR(250)
);

CREATE TABLE Student_Course (
    student_id INT NOT null,
    course_id int not null,
    FOREIGN KEY (student_id) REFERENCES Student(id),
    FOREIGN KEY (course_id) REFERENCES Course(id)
);

CREATE TABLE authority(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);

CREATE TABLE user(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  authority VARCHAR  NOT NULL ,
  FOREIGN KEY (authority) REFERENCES authority(id)
);

CREATE TABLE user_authorities(
  user_id INT,
  authority_id int,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (authority_id) REFERENCES authority(id)
);


