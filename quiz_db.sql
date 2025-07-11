CREATE DATABASE IF NOT EXISTS quiz_db;
USE quiz_db;

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT NOT NULL,
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    correct_option INT
);
INSERT INTO questions (question, option1, option2, option3, option4, correct_option)
VALUES
('What is the capital of France?', 'Berlin', 'Madrid', 'Paris', 'Lisbon', 3),
('Which language runs in a web browser?', 'Java', 'C', 'Python', 'JavaScript', 4);

CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    score INT
);
