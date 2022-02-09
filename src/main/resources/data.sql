insert into article(id,title,content) values(1,'가가가가','1111');
insert into article(id,title,content) values(2,'나나나나','2222');
insert into article(id,title,content) values(3,'다다다다','3333');


--article 더미 데이터--

insert into article(id,title,content) values(4,'내가 가장 좋아하는 음식은?','댓글 ㄲ');
insert into article(id,title,content) values(5,'내가 가장 싫어하는 음식은?','댓글 ㄲ');
insert into article(id,title,content) values(6,'내가 지금 하고 싶은 것은?','댓글 ㄲ');

--comment 더미 데이터--

--4번 게시물의 댓글들--
insert into comment(id,article_id,nick_Name,body) values(1,4,'jyyoun1022','콩나물 국밥');
insert into comment(id,article_id,nick_Name,body) values(2,4,'syyoun0123','김치찌개');
insert into comment(id,article_id,nick_Name,body) values(3,4,'ssilady0721','라면');

--5번 게시물의 댓글들--
insert into comment(id,article_id,nick_Name,body) values(4,5,'jyyoun1022','무');
insert into comment(id,article_id,nick_Name,body) values(5,5,'syyoun0123','가지');
insert into comment(id,article_id,nick_Name,body) values(6,5,'ssilady0721','후추');

--6번 게시물의 댓글들--
insert into comment(id,article_id,nick_Name,body) values(7,6,'jyyoun1022','취업');
insert into comment(id,article_id,nick_Name,body) values(8,6,'syyoun0123','취업');
insert into comment(id,article_id,nick_Name,body) values(9,6,'ssilady0721','취업');