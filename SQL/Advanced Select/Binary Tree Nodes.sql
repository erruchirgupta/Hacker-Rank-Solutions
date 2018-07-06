--     Author: Ruchir Gupta
--     Github: https://github.com/erruchirgupta
-- HackerRank: https://hackerrank.com/RuchirGupta

-- ORACLE SQL SOLUTION

-- SOLUTION 1
SELECT N,
    CASE
        WHEN P IS NULL THEN 'Root'
        WHEN N IN (SELECT P FROM BST) THEN 'Inner'
        ELSE 'Leaf'
    END
FROM BST ORDER BY N;


-- SOLUTION 2
SELECT N,
    CASE
        WHEN P IS NULL THEN 'Root'
        WHEN EXISTS (SELECT P FROM BST B WHERE A.N=B.P) THEN 'Inner'
        ELSE 'Leaf'
    END
FROM BST A ORDER BY N;
