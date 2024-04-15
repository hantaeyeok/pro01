select * from notice;

drop table notice;
create table notice(no number, title varchar2(200), content varchar2(2000), resdate timestamp default sysdate, visited number);
create sequence nseq INCREMENT by 1 start with 1;
insert into notice values (nseq.nextval, '���� ����1', '���� ����1', sysdate, 0);
insert into notice values (nseq.nextval, '���� ����2', '���� ����2', sysdate, default);

drop SEQUENCE nseq;
SELECT *
  FROM all_sequences
 WHERE sequence_name = 'nesq';