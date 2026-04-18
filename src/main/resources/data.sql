INSERT INTO my_blog_app.posts (title, content, created_at)
SELECT 'Getting Started with Spring Boot',
       'Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications. In this post we explore the basics of setting up a project using Spring Initializr and understanding the project structure.',
       NOW()
    WHERE NOT EXISTS (SELECT 1 FROM my_blog_app.posts WHERE title = 'Getting Started with Spring Boot');

INSERT INTO my_blog_app.posts (title, content, created_at)
SELECT 'Understanding Dependency Injection',
       'Dependency Injection is a fundamental concept in Spring Framework. It allows us to write loosely coupled code that is easy to test and maintain. In this post we explore how Spring manages beans and their lifecycle.',
       NOW()
    WHERE NOT EXISTS (SELECT 1 FROM my_blog_app.posts WHERE title = 'Understanding Dependency Injection');

INSERT INTO my_blog_app.posts (title, content, created_at)
SELECT 'Working with JPA and Hibernate',
       'JPA makes database operations simple and elegant. We explore entity mappings, relationships like @OneToMany and @ManyToOne, and how Spring Data JPA repositories reduce boilerplate code significantly.',
       NOW()
    WHERE NOT EXISTS (SELECT 1 FROM my_blog_app.posts WHERE title = 'Working with JPA and Hibernate');