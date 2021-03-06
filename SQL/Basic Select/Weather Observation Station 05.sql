--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

-- ORACLE SQL SOLUTION

SELECT * FROM (
SELECT CITY, LENGTH(CITY) FROM STATION 
ORDER BY LENGTH(CITY), CITY ) 
WHERE ROWNUM <= 1;

SELECT * FROM (
SELECT CITY, LENGTH(CITY) FROM STATION 
ORDER BY LENGTH(CITY) DESC, CITY ) 
WHERE ROWNUM <= 1;
