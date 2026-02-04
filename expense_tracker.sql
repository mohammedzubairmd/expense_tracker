CREATE DATABASE expense_tracker;
USE expense_tracker;
DROP TABLE expenses;
USE expense_tracker;

CREATE TABLE expenses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    amount DOUBLE,
    category VARCHAR(255),
    date DATE,
    type VARCHAR(255)
);
