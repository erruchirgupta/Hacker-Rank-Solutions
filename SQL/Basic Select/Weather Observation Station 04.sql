--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

-- ORACLE SQL SOLUTION

SELECT (COUNT(CITY) - COUNT(DISTINCT CITY)) AS DIFF FROM STATION;
