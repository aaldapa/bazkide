--liquibase formatted sql
--changeset elorak:insert-fee_types
INSERT INTO T_FEE_TYPES (FEE_NAME, DESCRIPTION, AMOUNT, INITIAL_MONTH, PERIODICITY, CREATED_ON, CREATED_BY)
VALUES
('INDIVIDUAL', 'Tipo de cuota individual. Un único socio', 33.00, 1, 12, CURRENT_TIMESTAMP, 'liquibase'),
('FAMILIAR', 'Tipo de cuota familiar. Todos los socios de la unidad familiar', 43.00, 1, 12, CURRENT_TIMESTAMP, 'liquibase');
