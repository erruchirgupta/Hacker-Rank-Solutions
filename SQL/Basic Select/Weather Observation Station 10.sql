--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

SELECT DISTINCT CITY FROM STATION
WHERE NOT REGEXP_LIKE (CITY, '[aeiouAEIOU]$') 
ORDER BY CITY;
