SELECT * FROM "MEMBER";
--1번부터 5번까지 데이터 가져오기
--rownum 오라클이 제공하는 가상컬럼을 이용
SELECT * FROM
(SELECT ROWNUM AS RNUM,M.*
FROM (SELECT *
	FROM MEMBER ORDER BY ENROLLDATE DESC)M)   --조인이필요하다면 ORDER안에 JOIN을써주면된다.
WHERE RNUM BETWEEN 6 AND 10;




