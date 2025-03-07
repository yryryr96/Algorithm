-- 코드를 작성해주세요
WITH FE AS (SELECT SUM(CODE) AS CODE FROM SKILLCODES WHERE CATEGORY = 'Front End')

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS AS D, FE
WHERE D.SKILL_CODE & FE.CODE
ORDER BY ID
