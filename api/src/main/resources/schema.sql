DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER (
    EMAIL		VARCHAR(100) NOT NULL,
    NICKNAME        VARCHAR(100),
    PASSWORD	VARCHAR(100),
    NAME 	VARCHAR(100),
    TEL		VARCHAR(20),	
    PRIMARY KEY (EMAIL)
);
