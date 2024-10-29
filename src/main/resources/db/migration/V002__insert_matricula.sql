-- src/main/resources/db/migration/V002__insert_matricula.sql

INSERT INTO matricula (nome, rm, turma, curso, status) VALUES
('John Doe', 'RM123456', 'Turma A', 'Computer Science', 'ATIVA'),
('Jane Smith', 'RM654321', 'Turma B', 'Information Systems', 'ATIVA'),
('Alice Johnson', 'RM112233', 'Turma C', 'Software Engineering', 'ATIVA'),
('Bob Brown', 'RM445566', 'Turma D', 'Data Science', 'ATIVA'),
('Charlie Davis', 'RM778899', 'Turma E', 'Cyber Security', 'ATIVA'),
('Diana Evans', 'RM998877', 'Turma F', 'Artificial Intelligence', 'ATIVA');