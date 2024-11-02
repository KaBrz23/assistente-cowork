-- src/main/resources/db/migration/V002__insert_reserva.sql

INSERT INTO reserva (nome, mesa, data, status) VALUES
('John Doe', 'A10', '2024-11-01 09:00:00',  'ATIVA'),
('Jane Smith', 'B02', '2024-11-01 10:00:00', 'ATIVA'),
('Alice Johnson', 'C08', '2024-11-01 11:00:00', 'ATIVA'),
('Bob Brown', 'F10', '2024-11-01 12:00:00', 'ATIVA')