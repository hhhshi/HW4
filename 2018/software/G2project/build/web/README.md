CREATE TABLE bookmarks_categories(
cat_id number(38) NOT NULL,
cat_name varchar2(255) NOT NULL,
CONSTRAINT pk_cat_id PRIMARY KEY(cat_id)
);

CREATE sequence bookmarks_categories_seq start with 1
increment by 1;

SET DEFINE off;
CREATE OR REPLACE TRIGGER bookmarks_categories_trigger
BEFORE INSERT ON bookmarks_categories
FOR EACH ROW
BEGIN
    :new.cat_id := bookmarks_categories_seq.NEXTVAL;
END;


INSERT INTO bookmarks_categories (cat_name) VALUES ('news');
INSERT INTO bookmarks_categories (cat_name) VALUES ('social media');
INSERT INTO bookmarks_categories (cat_name) VALUES ('finance');
INSERT INTO bookmarks_categories (cat_name) VALUES ('video');

CREATE TABLE bookmarks(
bookmark_id number(10) NOT NULL,
page_name varchar2(255) NOT NULL,
url varchar2(255) NOT NULL,
username varchar2(125) NOT NULL,
cat number(38),
note varchar2(255),
date_saved timestamp(6),
date_modified timestamp(6),
CONSTRAINT pk_bookmark_id PRIMARY KEY(bookmark_id),
CONSTRAINT fk_bookmarks_category FOREIGN KEY (cat) REFERENCES bookmarks_categories (cat_id)
);

CREATE sequence bookmarks_seq start with 1
increment by 1;

SET DEFINE off;
CREATE OR REPLACE TRIGGER bookmarks_trigger
BEFORE INSERT ON bookmarks
FOR EACH ROW
BEGIN
    :new.bookmark_id := bookmarks_seq.NEXTVAL;
END;

INSERT INTO bookmarks (page_name, url, username, cat, note, date_saved, date_modified) VALUES ('The New York Times', 'https://www.nytimes.com/', 'jack@jack.com', '1', 'The New York Times home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, cat, note, date_saved, date_modified) VALUES ('Press-Citizen', 'https://www.press-citizen.com/', 'jack@jack.com', '1', 'Iowa City Press-Citizen home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, cat, note, date_saved, date_modified) VALUES ('Facebook', 'https://facebook.com', 'jack@jack.com', '2', 'Facebooks home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, cat, note, date_saved, date_modified) VALUES ('Twitter', 'https://twitter.com', 'test@test.com', '2', 'Twitters home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, cat, note, date_saved, date_modified) VALUES ('Yahoo Finance', 'https://finance.yahoo.com/', 'test@test.com', '3', 'Yahoo Finance home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, cat, note, date_saved, date_modified) VALUES ('Youtube', 'https://www.youtube.com/', 'jack@jack.com', '4', 'Youtube home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, cat, note, date_saved, date_modified) VALUES ('Ted Talk', 'https://www.ted.com/', 'test@test.com', '4', 'Ted Talks home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);	

SELECT * FROM bookmarks;




CREATE TABLE bookmarks_siteusers(
email varchar2(50) NOT NULL,
passwd varchar2(50) NOT NULL,
firstname varchar2(50),
lastname varchar2(50),
CONSTRAINT pk__bookmarks_siteusers PRIMARY KEY (email)
);

INSERT INTO bookmarks_siteusers (email, passwd, firstname, lastname) VALUES ('jack@jack.com', 'password', 'Jack', 'Keller');
INSERT INTO bookmarks_siteusers (email, passwd, firstname, lastname) VALUES ('test@test.com', 'password', 'Test', 'User');

SELECT * FROM bookmarks_siteusers;



CREATE TABLE bookmarks_usersinroles(
email varchar2(50) NOT NULL,
rolename varchar2(50) NOT NULL,
CONSTRAINT pk_bookmarks_usersinroles PRIMARY KEY (email, rolename)
);

INSERT INTO bookmarks_usersinroles (email, rolename) VALUES ('jack@jack.com', 'admin');
INSERT INTO bookmarks_usersinroles (email, rolename) VALUES ('test@test.com', 'user');

SELECT * FROM bookmarks_usersinroles;