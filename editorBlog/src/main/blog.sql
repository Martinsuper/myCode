CREATE TABLE blog_article
(
    id int PRIMARY KEY AUTO_INCREMENT,
    first_editor_time datetime,
    modify_time datetime,
    article_title varchar(255),
    article_category varchar(255),
    article_markdown text,
    article_html text
);