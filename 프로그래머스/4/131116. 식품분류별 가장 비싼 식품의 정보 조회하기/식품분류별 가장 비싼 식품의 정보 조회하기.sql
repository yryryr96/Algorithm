-- 코드를 입력하세요
WITH F2 AS (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
    )

SELECT F1.CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT AS F1
JOIN F2
ON F1.CATEGORY = F2.CATEGORY
WHERE F1.CATEGORY = F2.CATEGORY AND F1.PRICE = F2.MAX_PRICE
ORDER BY MAX_PRICE DESC