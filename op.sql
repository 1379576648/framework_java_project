select  d.*, s.STAFF_NAME from  DEPT d left join STAFF s on d.STAFF_ID= s.STAFF_ID where s.IS_DELETED=0
