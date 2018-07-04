--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

SELECT DISTINCT CITY FROM STATION
WHERE REGEXP_LIKE (CITY, '^[aeiouAEIOU].*[aeiouAEIOU]$') 
ORDER BY CITY;
