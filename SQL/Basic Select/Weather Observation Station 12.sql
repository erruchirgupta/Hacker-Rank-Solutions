--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

-- ORACLE SQL SOLUTION

SELECT DISTINCT CITY FROM STATION
WHERE NOT REGEXP_LIKE (CITY, '^[aeiouAEIOU]|[aeiouAEIOU]$') 
ORDER BY CITY;
