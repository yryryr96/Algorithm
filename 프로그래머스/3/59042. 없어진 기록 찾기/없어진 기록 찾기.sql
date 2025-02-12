-- 코드를 입력하세요
# SELECT AO.ANIMAL_ID, AO.NAME FROM ANIMAL_OUTS as AO LEFT JOIN ANIMAL_INS as AI ON AO.ANIMAL_ID = AI.ANIMAL_ID WHERE AI.ANIMAL_ID IS NULL ORDER BY AO.ANIMAL_ID;

select ao.animal_id, ao.name from animal_outs ao where ao.animal_id not in (select ai.animal_id from animal_ins ai) order by ao.animal_id;

