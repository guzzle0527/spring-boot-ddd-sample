CREATE TABLE user (
  id INT PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  gender CHAR(1) NOT NULL,
  birth_day DATE NOT NULL,
  mail_address VARCHAR(300) NOT NULL,
  insert_date TIMESTAMP NOT NULL,
  update_date TIMESTAMP NOT NULL,
  CONSTRAINT qa_mail_address UNIQUE (mail_address)
);

CREATE TABLE task (
  id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  user_id INT NOT NULL,
  insert_date TIMESTAMP NOT NULL,
  update_date TIMESTAMP NOT NULL
);

CREATE SEQUENCE "seq_user_id";
CREATE SEQUENCE "seq_task_id";