
CREATE TABLE topic(topic_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, topic_name VARCHAR(100), description VARCHAR(250));
CREATE TABLE question(question_id INT  AUTO_INCREMENT NOT NULL PRIMARY KEY, topic_id INT, question_description VARCHAR(200), option1 VARCHAR(100),option2 VARCHAR(100),option3 VARCHAR(100),option4 VARCHAR(100), correct_answer VARCHAR(100), FOREIGN KEY(topic_id) references topic(topic_id) );
