--insert into blood(abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
--values(1,2, 4, 0, 0, 5, 3, 2, 6);
--insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
--values(1002,1, 0, 0, 0, 0, 8, 7, 0);
--insert into blood(id, abminus, abplus, aminus, aplus, bminus, bplus, ominus, oplus)
--values(1003,0, 0, 1, 3, 5, 5, 9, 3);
insert into address(city, country, number, street)
values('Novi Sad', 'Serbia', 8,'Strazilovska');
--insert into address
--values(1002, 'Novi Sad', 'Serbia', 18,'Bulevar Oslobodjenja');
--insert into address
--values(1003,'Novi Sad', 'Serbia', 24,'Bulevar Jase Tomica');
--insert into address
--values(1,'Novi Sad', 'Serbia', 4,'Bulevar Cara Lazara');

--insert into blood_bank
--values(1001, 'tLeiJ6w79JdrILqI34F6kYM3UAWENV8RjeZvi0LVtJochrXWJ7mpt0Cdedka8lVWUPnCFLZOhJbcS8ao9VFgwQ==', 'Best blood bank', 'newlife@gmail.com',  'New Life', 4.4, 1001, 1001);
--insert into blood_bank
--values(1002, 'W3QW1vpKFX9NUJ94HF0klON+lRaPBaSgx7mwAgV0b0ml4uVu7t2+2FoNDLqweFKzw4drCuaf0mPRbylQaja3Nw==', 'Best blood bank', 'bloodyhell@gmail.com',  'Bloody Hell', 3.4, 1002, 1002);
--insert into blood_bank
--values(1003, '4rijtG2K/XHcaesRU2gLHS5LC0QJoqMmKGKQrj4OmNLoxQjsjwUc+w60BFi3fR+0pO/BtrSma8yEJ1+bwAoQHQ==', 'Best blood bank', 'bloodymary@gmail.com',  'Bloody Mary', 2.4, 1003, 1003);

--insert into admin
--values(1001, '1985-05-05', 'ana@gmail.com', 'Ana', 1, 'Savic', 'ana', 1, 'ana', null);
--insert into admin
--values(1002, '1995-12-10', 'marko@gmail.com', 'Marko', 0, 'Markovic', 'marko', 1, '123', null);
--insert into admin
--values(1003, '2000-06-03', 'saska@gmail.com', 'Saska', 1, 'Vujovic', 'saska', 1, '123', null);
insert into customer(dob, email, first_name, gender, last_name, password, role, username, address_id)
select '2000-04-04', 'mihajlo@gmail.com', 'Mihajlo', 0, 'Maksimovic', 'sifra123', 3, 'mihajlo00', id from address where street='Strazilovska' and number=8
--insert into customer
--values(1002, '2000-05-05', 'customer1@gmail.com', 'CustFi', 0, 'CustLa', 'sifra123', 3, 'cust00', 1002);