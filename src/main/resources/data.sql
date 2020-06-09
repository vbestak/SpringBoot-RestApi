INSERT INTO Student ( first_name, last_name, birthDate, JMBAG, ECTSCount) VALUES
  ('Iva', 'Ivic', '11.11.1998.', '0246066954', 60),
  ('Ivan', 'Doe', '11.11.1998.', '0246573821', 153),
  ('Ivanic', 'Doe', '11.11.1998.', '0246573822', 152),
  ('Ivana', 'Horvat', '11.11.1998.', '9275633956', 120);

insert into Course (name, ECTS, semester) values
 ('Java', 7, 'summer'),
 ('Web aplikacije u Javi', 7, 'winter');

 insert into Student_Course (student_id, course_id) VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 2),
    (4, 2),
    (3, 1);

insert into authority(id, name)
values  (1, 'ROLE_ADMIN'),
        (2, 'ROLE_USER'),
        (3, 'ROLE_DELETER');

insert into user(id, username, password, first_name, last_name, authority)
values  (1, 'admin', '$2y$10$o7p0M/fmiwiSJvb0Q8zFruGyHedP3Cc3ClmvDWEd7JO.Rlp.SX.ly', 'admin', 'admin', 1),
        (2, 'user', '$2y$10$o7p0M/fmiwiSJvb0Q8zFruGyHedP3Cc3ClmvDWEd7JO.Rlp.SX.ly', 'user', 'user', 2),
        (3, 'deleter', '$2y$10$o7p0M/fmiwiSJvb0Q8zFruGyHedP3Cc3ClmvDWEd7JO.Rlp.SX.ly', 'deleter', 'deleter', 2);

/*lozinke = pass*/

insert into user_authorities(user_id, authority_id)
values  (1, 1),
        (2, 2),
        (3, 3),
        (3, 2);
