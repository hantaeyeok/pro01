

select * from qna;



-- plevel -> 1: 질문 , 2 : 답변
-- parno -> 질문(부모)글번호, 질문:자기자신번호, 답변 : 질문에 대한 글번호

--질문 및 답변의 목록 출력 : 질문 (부모)글번호인 parno 의 내림차순으로하고, 같은 경우는 질문부터 출력될 수 있도록 ploevel의 오름차순으로 정렬
select * from qna order by parno desc, plevel asc;

-- 질문등록
insert into qna values(qseq.nextval,1,null,'질문1','질문1내용',default,0,'kkt');
update qna set parno=qseq.currval 
where no = (select * from(select no from qna order by no desc) where rownum<=1); 


-- 답변 등록
insert into qna values(qseq.nextval,2,1,'질문1의 답변1','질문 1의 답변1내용',default,0,'admin');

--질문 및 답변 수정
update qna set title='', content='' where no=1;

--질문 및 답변 삭제
delete qna where no=1;

--질문 상세보기 및 해당 질문에 대한 답변보기

최근 질문 및 답변 목록 출력
select from (selelct * from qna order by )
