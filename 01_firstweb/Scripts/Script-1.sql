CREATE USER WEB IDENTIFIED BY WEB DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
GRANT CONNECT, RESOURCE TO WEB;
