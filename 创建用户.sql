-- 删除临时表空间
DROP TABLESPACE user_temp INCLUDING CONTENTS AND DATAFILES; 
-- 删除数据表空间
DROP TABLESPACE user_data INCLUDING CONTENTS AND DATAFILES; 
-- 删除用户
drop user power cascade;


/*第1步：创建临时表空间  */
create temporary tablespace user_temp
tempfile 'C:\Program Files (x86)\user_temp.dbf'
size 50m
autoextend on --自动增长
next 50m maxsize 20480m 
extent management local;

/*第2步：创建数据表空间  */
create tablespace user_data
logging
datafile 'C:\Program Files (x86)\user_data.dbf'
size 50m
autoextend on --自动增长
next 50m maxsize 20480m
extent management local;

/*第3步：创建用户并指定表空间  */
create user power identified by 123456
default tablespace user_data
temporary tablespace user_temp;

/*第4步：给用户授予权限  */
grant connect,resource,dba to power;