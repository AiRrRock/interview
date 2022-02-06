DROP TABLE students IF EXISTS;
CREATE TABLE IF NOT EXISTS students (id bigserial, name VARCHAR(255), mark DECIMAL(3,2), PRIMARY KEY (id));
INSERT INTO students (name, mark) VALUES ('Bob', 5.0);