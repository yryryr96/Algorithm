-- 코드를 작성해주세요
SELECT SUM(HG.SCORE) AS SCORE, HG.EMP_NO AS EMP_NO, HE.EMP_NAME AS EMP_NAME, HE.POSITION AS POSITION, HE.EMAIL AS EMAIL
FROM HR_GRADE AS HG
INNER JOIN HR_EMPLOYEES AS HE
ON HG.EMP_NO = HE.EMP_NO
GROUP BY HG.EMP_NO
ORDER BY SCORE DESC
LIMIT 1;