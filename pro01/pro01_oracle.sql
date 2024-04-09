select * from member;
select * from notice;
select * from BTRAFFIC;
select * from NOTICE;

insert into notice values (nseq.nextval, '더미 제목1', '더미 내용1', sysdate, 0);
insert into notice values (nseq.nextval, '더미 제목2', '더미 내용2', sysdate, default);

insert into member values ('kkt','1234','hty','hty@org.com','1324-1234-1234');