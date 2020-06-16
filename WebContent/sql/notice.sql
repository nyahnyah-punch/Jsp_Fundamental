memberCREATE TABLE notice(
#보여지는 데이터
n_num INT PRIMARY KEY,
n_writer VARCHAR(20) NOT NULL,#비워둘 수 없게 not null처리
n_title VARCHAR(300) NOT NULL,
n_content VARCHAR(10000) NOT NULL,
n_regdate DATETIME NOT NULL);

INSERT INTO notice(n_num, n_writer, n_title, n_content, n_regdate)
VALUES(1, '철수', '제목', '내용', NOW());

SELECT n_num, n_writer, n_title, n_content,
DATE_FORMAT(n_regdate, '%Y.%m.%d %h:%i')
FROM notice
ORDER BY n_num DESC
LIMIT 0,10;

UPDATE notice
SET n_writer='영희', n_title='타이틀', n_content='공지내용',
n_regdate = NOW();

SELECT n_num, n_writer, n_title, n_content,
DATE_FORMAT(n_regdate, '%Y.%m.%d %h:%i')
FROM notice
WHERE n_num=1;

DELETE FROM notice
WHERE n_num=1;