insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
values(1001,2, 4, 0, 0, 5, 3, 2, 7);
insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
values(1002,1, 0, 0, 0, 0, 8, 7, 0);
insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
values(1003,0, 0, 1, 3, 5, 5, 9, 3);


insert into address
values(1004,'New York', 'USA', 8,'Saint Johns');
insert into address
values(1005, 'Novi Sad', 'Serbia', 18,'Bulevar Oslobodjenja');
insert into address
values(1006,'Novi Sad', 'Serbia', 24,'Bulevar Jase Tomica');

insert into blood_bank
values(1007, 'tLeiJ6w79JdrILqI34F6kYM3UAWENV8RjeZvi0LVtJochrXWJ7mpt0Cdedka8lVWUPnCFLZOhJbcS8ao9VFgwQ==', 'Best blood bank', 'newlife@gmail.com', '21:00', 'New Life', 5, 4.4, '08:00', 1004, 1001);
insert into blood_bank
values(1008, 'W3QW1vpKFX9NUJ94HF0klON+lRaPBaSgx7mwAgV0b0ml4uVu7t2+2FoNDLqweFKzw4drCuaf0mPRbylQaja3Nw==', 'Best blood bank', 'bloodyhell@gmail.com', '20:00', 'Bloody Hell', 6, 3.4 , '08:00', 1005, 1002);
insert into blood_bank
values(1009, '4rijtG2K/XHcaesRU2gLHS5LC0QJoqMmKGKQrj4OmNLoxQjsjwUc+w60BFi3fR+0pO/BtrSma8yEJ1+bwAoQHQ==', 'Best blood bank', 'bloodymary@gmail.com', '19:00', 'Bloody Mary', 4, 2.4 , '07:00', 1006, 1003);

insert into address
values(1010, 'Novi Sad', 'Serbia', 2,'Zeleznicka');
insert into address
values(1011,'Novi Sad', 'Serbia', 1,'Bulevar Kralja Petra');
insert into address
values(1012, 'Novi Sad', 'Serbia', 3,'Temerinska');
insert into address
values(1013, 'Novi Sad', 'Serbia', 32,'Bulevar Oslobodjenja');
insert into address
values(1014, 'Novi Sad', 'Serbia', 12,'Zeleznicka');
insert into address
values(1015,'Novi Sad', 'Serbia', 26,'Bulevar Kralja Petra');
insert into address
values(1016, 'Novi Sad', 'Serbia', 28,'Temerinska');
insert into address
values(1017, 'Novi Sad', 'Serbia', 20,'Bulevar Oslobodjenja');

insert into users
values(1019, '2000-06-03', 'mina@gmail.com', 'Mina', 0, 'Minic', '123', 0, 'mina', 1010);
insert into users
values(1020, '1995-12-10', 'halid@gmail.com', 'Halid', 1, 'Pasanovic', '123', 1, 'halid', 1011);
insert into users
values(1021, '2000-06-03', 'saska@gmail.com', 'Saska', 0, 'Vujovic', '123', 1, 'saska', 1012);
insert into users
values(1022, '2000-05-05', 'nikola@gmail.com', 'Nikola', 1, 'Rosic', '123', 1, 'nikola', 1013);
insert into users
values(1023, '1995-12-10', 'nina@gmail.com', 'Nina', 1, 'Ninic', '123', 2, 'nina', 1014);
insert into users
values(1024, '2000-04-04', 'milka@gmail.com', 'Milka', 2, 'Milkic', '123', 2, 'milka', 1015);
insert into users
values(1025, '2000-04-04', 'mihajlo@gmail.com', 'Mihajlo', 0, 'Maksimovic', '123', 2, 'miha', 1016);
insert into users
values(1026, '2000-05-05','marko@gmail.com', 'Marko', 2, 'Markovic', '123', 2, 'marko', 1017);

insert into head_admins
values(1019);

insert into admin
values(1020, 1007);
insert into admin
values(1021, 1008);
insert into admin
values(1022, 1009);

insert into customer
values('101010', '066111221', 'zaposlen', 'firma', 1023);
insert into customer
values('202020', '064434444', 'nezaposlena', 'domacica', 1024);
insert into customer
values('123123', '066422222', 'student', 'ftn', 1025);
insert into customer
values('321321', '066433123', 'student', 'pmf', 1026);

insert into complaints(answer, complaint_id, complaint_status, complaint_type, description, email_of_defendant, submission_date, customer_id, head_admin_id)
values('', 1027, 'UNANSWERED', 0, 'Predugo se ovde ceka', 'newlife@gmail.com','2022-12-12', 1023, null);
insert into complaints(answer, complaint_id, complaint_status,complaint_type, description, email_of_defendant, submission_date, customer_id, head_admin_id)
values('Zao nam je zbog utiska koji zgrada ostavlja na vas.', 1028, 'ANSWERED', 0, 'Zgrada je ocajna', 'bloodymary@gmail.com','2022-11-12', 1024, 1019);
insert into complaints(answer, complaint_id, complaint_status,complaint_type, description, email_of_defendant, submission_date, customer_id, head_admin_id)
values('', 1029, 'UNANSWERED', 1, 'Jako neprijatna radnica!', 'saska@gmail.com','2022-12-02', 1025, null);
insert into complaints(answer, complaint_id, complaint_status,complaint_type, description, email_of_defendant, submission_date, customer_id, head_admin_id)
values('Stupicemo u kontakt sa zaposlenim!', 1030, 'ANSWERED', 1, 'Izderao se na mene u hodniku', 'halid@gmail.com','2022-10-23', 1026, 1019);

insert into appointment(id, appointment_date, start_time, end_time, executed, blood_bank_id, customer_id)
values
    (1031, '2022-12-19', '11:00', '11:09', 'DONE', 1007, 1023),
    (1032, '2022-12-29', '11:30', '11:45', 'PENDING', 1008, 1023),
    (1033, '2022-12-19', '11:31', '11:45', 'DONE', 1009, 1024),
    (1034, '2022-12-19', '11:31', '11:45', 'CANCELLED', 1007, 1023),
    (1035, '2022-12-19', '11:31', '11:45', 'CANCELLED', 1007, 1024),
    (1036, '2022-12-19', '11:31', '11:45', 'DONE', 1009, 1023),
    (1037, '2022-12-30', '11:31', '11:45', 'PENDING', 1008, 1024),
    (1038, '2022-12-29', '11:31', '11:45', 'PENDING', 1009, 1023),
    (1039, '2022-12-28', '8:32', '10:31', 'PENDING', 1007, 1024);
