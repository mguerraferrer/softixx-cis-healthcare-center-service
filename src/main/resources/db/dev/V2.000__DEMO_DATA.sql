INSERT INTO common.private_practice (id, doctor_id, doctor_name, hash, active) VALUES
	 (1, 1, '', '0c5f36afaa498336', true);

INSERT INTO common.private_practice_functionality (id, private_practice_id, functionality_id, hash, active) VALUES
	 (1, 1, 26, 'fa60d7cb906676b7', true), 
	 (2, 1, 27, '7af396ac4c1991fa', true), 
	 (3, 1, 28, 'a779e5c021f6393c', true), 
	 (4, 1, 29, '8d1c488e6b3b3e90', true), 
	 (5, 1, 30, '98b62122e1b86f60', true), 
	 (6, 1, 34, '08a7efdba7cc940d', true), 
	 (7, 1, 35, '190dc6228f00ae36', true), 
	 (8, 1, 36, 'd3870b12a4d13170', true), 
	 (9, 1, 38, '798e390bf8fafc87', true), 
	 (10, 1, 39, 'ed3e897c79680dcd', true), 
	 (11, 1, 37, '2dac149f59caba7b', true), 
	 (12, 1, 40, '23eb6c81635909e4', true);

INSERT INTO common.private_practice_service (id, private_practice_id, doctor_speciality_id, code, description, subtotal, tax, discount, total, discount_start_date, discount_due_date, active) VALUES
	 (1, 1, 19, 'SCPEDIT', 'Consulta de Pediatría', 700.0, NULL, NULL, 700.0, NULL, NULL, true);

INSERT INTO common.private_practice_system_option (id, private_practice_id, auto_config_system_option_id, hash, active) VALUES
	 (1, 1, 1,'b30bf1713cad9b90',true),
	 (2, 1, 2,'a747c7ca773cd342',true),
	 (3, 1, 3,'d35b2563ea614987',true);