-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS Month, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN(SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE MONTH(START_DATE) IN (8, 9, 10)
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5)
    AND MONTH(START_DATE) IN (8,9,10)
GROUP BY Month, CAR_ID
ORDER BY Month, CAR_ID DESC