#笔录模块

##未录入笔录的案件信息

1. ###数据结构

    |序号|数据库字段名|内容|数据表|
    |----|----------|---|---|
    |1|CASEID|案件编号|CASE_M_CRIMINAL|
    |2|CASENAME|案件名称|CASE_M_CRIMINAL|
    |3|CASECLASS|案件类型|CASE_M_CRIMINAL|
    |4|PROCESSPERSONNAME|办案人员|CASE_M_CRIMINAL|
    |5|UNITNAME|办案单位|CASE_M_CRIMINAL|
    |6|DISPOSEDETAILS|简要案情|CASE_M_CRIMINAL|
    |7|INPUTTIME|录入时间|CASE_M_CRIMINAL|
    |8|MODIFIEDTIME|修改时间|CASE_M_CRIMINAL|

2. ###SQL查询语句

    ````sql
       SELECT CASEID,CASENAME,CASECLASS,PROCESSPERSONNAME,UNITNAME,DISPOSEDETAILS,INPUTTIME,MODIFIEDTIME
       FROM CASE_M_CRIMINAL
       WHERE CASEID NOT IN (SELECT CASEID FROM EA_RECORD_CASE)
       ORDER BY MODIFIEDTIME DESC
    ````
3. ###查询条件
    
    * 案件编号
    * 案件名称
    * 案件类型
    * 办案人员
    * 执法单位
    