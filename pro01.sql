

select * from qna;



-- plevel -> 1: ���� , 2 : �亯
-- parno -> ����(�θ�)�۹�ȣ, ����:�ڱ��ڽŹ�ȣ, �亯 : ������ ���� �۹�ȣ

--���� �� �亯�� ��� ��� : ���� (�θ�)�۹�ȣ�� parno �� �������������ϰ�, ���� ���� �������� ��µ� �� �ֵ��� ploevel�� ������������ ����
select * from qna order by parno desc, plevel asc;

-- �������
insert into qna values(qseq.nextval,1,null,'����1','����1����',default,0,'kkt');
update qna set parno=qseq.currval 
where no = (select * from(select no from qna order by no desc) where rownum<=1); 


-- �亯 ���
insert into qna values(qseq.nextval,2,1,'����1�� �亯1','���� 1�� �亯1����',default,0,'admin');

--���� �� �亯 ����
update qna set title='', content='' where no=1;

--���� �� �亯 ����
delete qna where no=1;

--���� �󼼺��� �� �ش� ������ ���� �亯����

�ֱ� ���� �� �亯 ��� ���
select from (selelct * from qna order by )
