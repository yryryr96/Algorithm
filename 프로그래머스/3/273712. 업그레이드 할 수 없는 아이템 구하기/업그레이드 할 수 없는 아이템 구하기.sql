-- 코드를 작성해주세요
SELECT I.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO AS I
LEFT JOIN ITEM_TREE AS T
ON I.ITEM_ID = T.PARENT_ITEM_ID
WHERE PARENT_ITEM_ID IS NULL
ORDER BY I.ITEM_ID DESC



# SELECT PARENT_ITEM_ID FROM ITEM_TREE