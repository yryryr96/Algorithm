WITH MAX_CNT AS (SELECT MEMBER_ID, COUNT(*) AS CNT
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID)


SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW AS R
JOIN MEMBER_PROFILE AS P
ON R.MEMBER_ID = P.MEMBER_ID
WHERE R.MEMBER_ID IN (SELECT DISTINCT(MEMBER_ID)
                    FROM REST_REVIEW
                    GROUP BY MEMBER_ID
                    HAVING COUNT(MEMBER_ID) = (SELECT MAX(CNT) FROM MAX_CNT))
ORDER BY REVIEW_DATE, REVIEW_TEXT



