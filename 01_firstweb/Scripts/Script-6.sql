SELECT * FROM BOARD_COMMENT WHERE BOARD_REF=1
START WITH BOARD_COMMENT_LEVEL=1
CONNECT BY PRIOR BOARD_COMMENT_NO=BOARD_COMMENT_REF; 

SELECT * FROM BOARD_COMMENT WHERE BOARD_REF=1 START WITH BOARD_COMMENT_LEVEL=1 CONNECT BY PRIOR BOARD_COMMENT_NO=BOARD_COMMENT_REF;