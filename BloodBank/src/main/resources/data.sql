insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
values(1001,2, 4, 0, 0, 5, 3, 2, 6);
insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
values(1002,1, 0, 0, 0, 0, 8, 7, 0);
insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
values(1003,0, 0, 1, 3, 5, 5, 9, 3);
insert into address
values(1004,'Novi Sad', 'Serbia', 8,'Strazilovska');
insert into address
values(1005, 'Novi Sad', 'Serbia', 18,'Bulevar Oslobodjenja');
insert into address
values(1006,'Novi Sad', 'Serbia', 24,'Bulevar Jase Tomica');

insert into blood_bank
values(1007, 'tLeiJ6w79JdrILqI34F6kYM3UAWENV8RjeZvi0LVtJochrXWJ7mpt0Cdedka8lVWUPnCFLZOhJbcS8ao9VFgwQ==', 'Best blood bank', 'newlife@gmail.com',  'New Life', 4.4, 1004, 1001);
insert into blood_bank
values(1008, 'W3QW1vpKFX9NUJ94HF0klON+lRaPBaSgx7mwAgV0b0ml4uVu7t2+2FoNDLqweFKzw4drCuaf0mPRbylQaja3Nw==', 'Best blood bank', 'bloodyhell@gmail.com',  'Bloody Hell', 3.4, 1005, 1002);
insert into blood_bank
values(1009, '4rijtG2K/XHcaesRU2gLHS5LC0QJoqMmKGKQrj4OmNLoxQjsjwUc+w60BFi3fR+0pO/BtrSma8yEJ1+bwAoQHQ==', 'Best blood bank', 'bloodymary@gmail.com',  'Bloody Mary', 2.4, 1006, 1003);

insert into admin
values(1010, '1985-05-05', 'ana@gmail.com', 'Ana', 1, 'Savic', 'ana', 1, 'ana', null);
insert into admin
values(1011, '1995-12-10', 'marko@gmail.com', 'Marko', 0, 'Markovic', 'marko', 1, '123', null);
insert into admin
values(1012, '2000-06-03', 'saska@gmail.com', 'Saska', 1, 'Vujovic', 'saska', 1, '123', null);

insert into address
values(1013, 'Novi Sad', 'Serbia', 2,'Bulevar Oslobodjenja');
insert into address
values(1014,'Novi Sad', 'Serbia', 2,'Bulevar Jase Tomica');

insert into customer
values(1015, '2000-04-04', 'mihajlo@gmail.com', 'Mihajlo', 0, 'Maksimovic', 'sifra123', 3, 'mihajlo00', 1013);
insert into customer
values(1016, '2000-05-05', 'customer1@gmail.com', 'CustFi', 0, 'CustLa', 'sifra1', 3, 'cust00', 1014);
