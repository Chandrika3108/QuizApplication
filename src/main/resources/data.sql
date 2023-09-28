insert into topic values(default,'Programming');
insert into topic values(default,'Software Development');
insert into topic values(default,'System Design');
insert into topic values(default,'Movies');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (101, 1, 'Whats the process of finding and fixing mistakes in code?', 'Debugging','Compiling','Optimizing','Testing','option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (102, 1, 'Which programming language is known for its use in web development?', 'Java', 'C', 'Python', 'HTML', 'option4');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (103, 1, 'What does SQL stand for?', 'Structured Query Language', 'Simple Query Language', 'Scripted Query Language', 'Sequential Query Language', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (104, 1, 'Which SQL statement is used to retrieve data from a database?', 'GET', 'PULL', 'SELECT', 'QUERY', 'option3');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (105, 1, 'Which programming paradigm focuses on the use of functions?', 'Object-Oriented Programming', 'Procedural Programming', 'Functional Programming', 'Structured Programming', 'option3');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (106, 1, 'In functional programming, what is immutability?', 'The ability to change variables', 'The use of loops', 'The state of being fixed and unchangeable', 'The use of multiple classes', 'option3');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (107, 1, 'What is a version control system?', 'A system to control software licensing', 'A system to manage database versions', 'A system to track changes in source code', 'A system to control hardware versions', 'option3');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (108, 1, 'Which version control system is commonly used in open-source projects?', 'Git', 'SVN', 'Mercurial', 'Perforce', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (109, 1, 'What is an IDE?', 'An Integrated Database Environment', 'An Input and Data Exchange', 'An Integrated Development Environment', 'An Interface Design Experience', 'option3');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (110, 1, 'Which IDE is commonly used for Java development?', 'Visual Studio Code', 'Eclipse', 'PyCharm', 'Sublime Text', 'option2');
INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (111, 2, 'What is the purpose of version control?', 'Managing software versions', 'Storing user data', 'Managing databases', 'Testing software', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (112, 2, 'Which version control system uses distributed repositories?', 'Git', 'SVN', 'Mercurial', 'Perforce', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (113, 2, 'What does API stand for?', 'Application Programming Interface', 'Automated Programming Interface', 'Advanced Programming Interface', 'Algorithmic Programming Interface', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (114, 2, 'Which HTTP method is used for retrieving data from a server?', 'GET', 'POST', 'PUT', 'DELETE', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (115, 2, 'What is the purpose of unit testing?', 'Testing the entire application', 'Testing the user interface', 'Testing the database', 'Testing individual units of code', 'option4');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (116, 2, 'Which testing technique is used to ensure that each line of code is executed at least once?', 'Unit testing', 'Integration testing', 'Functional testing', 'Code coverage testing', 'option4');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (117, 2, 'What is the purpose of a design pattern?', 'Making code complex', 'Enforcing standards', 'Solving common software problems', 'Making code shorter', 'option3');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (118, 2, 'Which design pattern is used to create objects without specifying the exact class?', 'Factory Method', 'Singleton', 'Decorator', 'Builder', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (119, 2, 'What does SOLID stand for in object-oriented design principles?', 'Single Object Language In Detail', 'Structured Object Layout In Development', 'Software Object Language and Interface Design', 'Single Responsibility, Open-Closed, Liskov Substitution, Interface Segregation, Dependency Inversion', 'option4');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (120, 2, 'Which design principle states that classes should be open for extension but closed for modification?', 'Single Responsibility Principle', 'Open-Closed Principle', 'Liskov Substitution Principle', 'Interface Segregation Principle', 'option2');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (121, 3, 'What is the purpose of system design?', 'Creating user interfaces', 'Writing code', 'Defining software requirements', 'Designing the architecture', 'option4');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (122, 3, 'Which aspect of system design focuses on data storage and retrieval?', 'User experience design', 'Interface design', 'Database design', 'Software development', 'option3');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (123, 3, 'What is scalability in the context of system design?', 'The ability to handle a large number of users', 'The ability to perform a specific task', 'The ability to manage databases', 'The ability to develop software quickly', 'option1');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (124, 3, 'Which term describes the process of adding new features to a system without breaking existing functionality?', 'Refactoring', 'Maintenance', 'Scaling', 'Continuous Integration', 'option1');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (125, 3, 'What is the purpose of a design pattern in system design?', 'Creating complex algorithms', 'Solving common design problems', 'Testing software', 'Creating user interfaces', 'option2');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (126, 3, 'Which design pattern is used to manage object creation in a flexible and controlled way?', 'Factory Method', 'Observer', 'Decorator', 'Singleton', 'option1');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (127, 3, 'What is the purpose of a use case diagram in system design?', 'Representing class hierarchies', 'Showing the flow of data', 'Modeling the interactions between users and a system', 'Defining database schemas', 'option3');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (128, 3, 'Which diagram is used to represent the static structure of a system?', 'Activity diagram', 'Sequence diagram', 'Component diagram', 'State diagram', 'option3');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (129, 3, 'What does REST stand for in the context of system design?', 'Representational State Transfer', 'Remote Execution System Toolkit', 'Responsive and Efficient System Technology', 'Reliable Event Synchronization Technique', 'option1');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (130, 3, 'Which architectural style emphasizes the separation of concerns and modularity?', 'Microservices architecture', 'Monolithic architecture', 'Peer-to-peer architecture', 'Client-server architecture', 'option1');



INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (131, 4, 'Which movie won the Academy Award for Best Picture in 2020?', 'Parasite', '1917', 'Joker', 'Once Upon a Time in Hollywood', 'option1');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (132, 4, 'In which movie does Tom Hanks play the role of Forrest Gump?', 'Saving Private Ryan', 'The Green Mile', 'Cast Away', 'Forrest Gump', 'option4');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (133, 4, 'Who directed the movie "Inception"?', 'Martin Scorsese', 'Christopher Nolan', 'Quentin Tarantino', 'Steven Spielberg', 'option2');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (134, 4, 'Which movie features the character Tony Stark as Iron Man?', 'The Avengers', 'Thor', 'Guardians of the Galaxy', 'Iron Man', 'option4');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (135, 4, 'Which movie is based on the novel by J.K. Rowling?', 'The Hunger Games', 'Divergent', 'The Chronicles of Narnia', 'Harry Potter and the Sorcerers Stone', 'option4');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (136, 4, 'In "The Lord of the Rings" trilogy, what is the name of the wizard who guides the main characters?', 'Saruman', 'Gandalf', 'Radagast', 'Frodo', 'option2');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (137, 4, 'Which animated movie features a young lion named Simba?', 'Finding Nemo', 'Toy Story', 'Shrek', 'The Lion King', 'option4');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (138, 4, 'In "Frozen," which character has the power to control ice and snow?', 'Anna', 'Elsa', 'Olaf', 'Sven', 'option2');

INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (139, 4, 'Which movie features the famous line "You cant handle the truth!"?', 'A Few Good Men', 'Rain Man', 'Top Gun', 'Mission: Impossible', 'option1');


INSERT INTO question (question_id, topic_id, question_description, option1, option2, option3, option4, correct_answer)
VALUES (140, 4, 'Who plays the role of Jack Dawson in the movie "Titanic"?', 'Brad Pitt', 'Leonardo DiCaprio', 'Matt Damon', 'Johnny Depp', 'option2');



INSERT INTO `users` (user_id,`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`)
 VALUES (default, 'chandrika','test@test.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE());


 INSERT INTO `authorities` (id, `user_id`, `name`)
  VALUES (default, 1, 'ROLE_USER');

 INSERT INTO `authorities` (id, `user_id`, `name`)
  VALUES (default, 1, 'ROLE_ADMIN');