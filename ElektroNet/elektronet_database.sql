-- Kreiranje baze podataka za elektronet aplikaciju

CREATE DATABASE IF NOT EXISTS Elektro_Net;
USE Elektro_Net;

-- Kreiranje tabele za korisnike(Signup)

CREATE TABLE IF NOT EXISTS Signup(

	meterCode VARCHAR(50) PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    usertype VARCHAR(20) NOT NULL

);

-- Tabela za nove korisnike(new_Customer)

CREATE TABLE IF NOT EXISTS new_Customer(

	name VARCHAR(100) NOT NULL,
    meter VARCHAR(50) PRIMARY KEY,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL

);

-- kreiranje tabele za informacije o brojilu

CREATE TABLE IF NOT EXISTS meter_info(

	meter_number VARCHAR(50) PRIMARY KEY,
    meter_location VARCHAR(50) NOT NULL,
    meter_type VARCHAR(50) NOT NULL,
    phase_code VARCHAR(10) NOT NULL,
    bill_type VARCHAR(50) NOT NULL,
    day VARCHAR(10) NOT NULL

);

-- Kreiranje tabele za racune

CREATE TABLE IF NOT EXISTS bill(

	meter_number VARCHAR(50) NOT NULL,
    month VARCHAR(20) NOT NULL,
    unit VARCHAR(20) NOT NULL,
    total_bill VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    PRIMARY KEY (meter_number, month)

);

-- Kreiranje tabele za takse i troskove

CREATE TABLE IF NOT EXISTS tax(

	cost_per_unit VARCHAR(20) NOT NULL,
    meter_rent VARCHAR(20) NOT NULL,
    service_charge VARCHAR(20) NOT NULL,
    service_tax VARCHAR(20) NOT NULL,
    acss VARCHAR(20) NOT NULL,
    fixed_tax VARCHAR(20) NOT NULL

);

-- Dodavanje admin korisnika

INSERT INTO signup (meterCode, username, name, password, usertype) VALUES
('admin001', 'admin', 'Administrator', 'admin123', 'Admin'),
('admin002', 'manager', 'Manager', 'manager123', 'Admin');

-- Dodavanje test korisnika

INSERT INTO new_customer (name, meter, address, city, state, email, phone) VALUES
('Marko Petrović', '123456', 'Knez Mihailova 15', 'Beograd', 'Srbija', 'marko.petrovic@email.com', '0612345678'),
('Ana Jovanović', '234567', 'Terazije 25', 'Beograd', 'Srbija', 'ana.jovanovic@email.com', '0623456789'),
('Petar Nikolić', '345678', 'Kralja Petra 10', 'Novi Sad', 'Srbija', 'petar.nikolic@email.com', '0634567890');

-- Dodavanje informacije o brojilima

INSERT INTO meter_info (meter_number, meter_location, meter_type, phase_code, bill_type, day) VALUES
('123456', 'Outside', 'Electric Meter', '011', 'Normal Bill', '30'),
('234567', 'Inside', 'Smart Meter', '022', 'Normal Bill', '30'),
('345678', 'Outside', 'Solar Meter', '033', 'Industrial Bill', '30');

-- Dodavanje racuna za test

INSERT INTO bill (meter_number, month, unit, total_bill, status) VALUES
('123456', 'January', '150', '2500', 'Paid'),
('123456', 'February', '180', '3000', 'Not Paid'),
('234567', 'January', '120', '2000', 'Paid'),
('234567', 'February', '140', '2300', 'Not Paid'),
('345678', 'January', '200', '4000', 'Paid'),
('345678', 'February', '220', '4400', 'Not Paid');

-- Dodavanje taksi i troskova

INSERT INTO tax (cost_per_unit, meter_rent, service_charge, service_tax, acss, fixed_tax) VALUES
('12', '50', '100', '18', '25', '200');

-- Dodavanje signup podataka za test korisnike

INSERT INTO signup (meterCode, username, name, password, usertype) VALUES
('123456', 'marko123', 'Marko Petrović', 'password123', 'Customer'),
('234567', 'ana123', 'Ana Jovanović', 'password123', 'Customer'),
('345678', 'petar123', 'Petar Nikolić', 'password123', 'Customer');

-- Dodavanje dodatnih racuna za test

INSERT INTO bill (meter_number, month, unit, total_bill, status) VALUES
('123456', 'March', '160', '2700', 'Not Paid'),
('234567', 'March', '130', '2150', 'Not Paid'),
('345678', 'March', '210', '4200', 'Not Paid');

-- Dodavanje dodatnih meseci za test

INSERT INTO bill (meter_number, month, unit, total_bill, status) VALUES
('123456', 'April', '170', '2850', 'Not Paid'),
('123456', 'May', '190', '4200', 'Not Paid'),
('234567', 'April', '125', '3150', 'Not Paid'),
('234567', 'May', '135', '4100', 'Not Paid'),
('345678', 'April', '210', '2075', 'Not Paid'),
('345678', 'May', '205', '2225', 'Not Paid');

-- Prikaz svih tabela

SELECT * FROM signup;
SELECT * FROM new_customer;
SELECT * FROM meter_info;
SELECT * FROM bill;
SELECT * FROM tax;

-- Test podaci za login

SELECT 'Test login podaci:' as 'Info';
SELECT 'Admin: username=admin, password=admin123' as 'Admin';
SELECT 'Customer: username=marko123, password=password123' as 'Customer';

-- Statistike

SELECT 'Statistike:' as 'Info';
SELECT COUNT(*) as 'Ukupno korisnika' FROM new_customer;
SELECT COUNT(*) as 'Ukupno racuna' FROM bill;
SELECT COUNT(*) as 'Placeni racuni' FROM bill WHERE status = 'Paid';
SELECT COUNT(*) as 'Neplaceni racuni' FROM bill WHERE status = 'Not Paid';
