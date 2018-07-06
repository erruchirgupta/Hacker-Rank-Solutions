--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

-- ORACLE SQL SOLUTION

SELECT DOCTOR, PROFESSOR, SINGER, ACTOR
FROM
    (SELECT * FROM
      (SELECT
            NAME,
            OCCUPATION,
            (ROW_NUMBER() OVER (PARTITION BY OCCUPATION ORDER BY NAME)) AS ROW_NUM
        FROM
            OCCUPATIONS
        ORDER BY
            NAME ASC) PIVOT (MIN(NAME) FOR OCCUPATION IN ('Doctor'    AS DOCTOR,
                                                          'Professor' AS PROFESSOR,
                                                          'Singer'    AS SINGER,
                                                          'Actor'     AS ACTOR))
ORDER BY
    ROW_NUM); 
