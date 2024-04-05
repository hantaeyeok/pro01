drop table traffic;
-- traffic
create table btraffic(tno varchar(20) primary key not null, ttype varchar(20) not null, no varchar(20) not null, route varchar(50), coment varchar(1000));
create table straffic(tno varchar(20) primary key not null, ttype varchar(20) not null, no varchar(20) not null, route varchar(50), coment varchar(1000));

drop sequence tseq;
create sequence btseq start with 1 increment by 1;
create SEQUENCE stseq start with 1 increment by 1;

-- guide
create table guide(pcode int primary key, pname varchar(100) not null, ptype varchar(3) not null, paddr varchar(200) not null, ptel varchar(20), pgps varchar(50), pcoment varchar(2000));

-- data
create table data(no int primary key, title varchar(50) not null, content varchar(4000) not null, datafile varchar(200), resdate timestamp default sysdate, visited int);
create sequence dseq start with 1 increment by 1;

-- notice
create table notice (no int primary key, title varchar(50) not null, content varchar(4000), resdate TIMESTAMP default sysdate, visited int);
create sequence nseq start with 1 increment by 1;
select * from notice;
-- member
create table member(id varchar(12) primary key, pw varchar(12) not null, name varchar(20) not null, tel varchar(20) not null);

-- qna
create table qna(no int primary key, plevel varchar(50), parno int, title varchar(50), content varchar(4000), resdate TIMESTAMP default sysdate, visited int, aid varchar(20));

alter table qna add constraint aidfkey foreign key (aid) references member(id);


-- traffic bus

-- traffic subway


