--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

-- ORACLE SQL SOLUTION

SELECT
    E.company_code,
    C.founder,
    COUNT(DISTINCT lead_manager_code),
    COUNT(DISTINCT senior_manager_code),
    COUNT(DISTINCT manager_code),
    COUNT(DISTINCT employee_code)
FROM
    Employee E
INNER JOIN
    Company C
ON
    E.company_code = C.company_code
GROUP BY
    E.company_code,
    C.founder
ORDER BY
    E.company_code;
