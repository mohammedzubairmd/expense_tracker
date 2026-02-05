CREATE DATABASE IF NOT EXISTS expense_tracker;

USE expense_tracker;

CREATE TABLE IF NOT EXISTS expenses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    category VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    type VARCHAR(255)
);
