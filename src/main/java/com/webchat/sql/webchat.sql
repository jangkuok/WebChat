CREATE TABLE MEMBER(
                       id VARCHAR(100) PRIMARY KEY,
                       pw VARCHAR(50) NOT NULL,
                       nickname varchar(100) NOT NULL
);

CREATE TABLE CHATROOM(
                         roomNo INTEGER PRIMARY KEY,
                         roomName VARCHAR(100) NOT NULL,
                         leaderId VARCHAR(100) NOT NULL
);

CREATE SEQUENCE seq_chatroom START 1;

CREATE TABLE MEMBER_CHATROOM(
                                joinNo INTEGER PRIMARY KEY,
                                roomNo INTEGER NOT NULL,
                                id VARCHAR(100) NOT NULL,
                                CONSTRAINT CHATROOM_MEMBER_FK FOREIGN KEY(roomNo) REFERENCES CHATROOM ON DELETE CASCADE,
                                CONSTRAINT MEMBER_CHATROOM_FK FOREIGN KEY(id) REFERENCES MEMBER ON DELETE CASCADE
);

CREATE SEQUENCE seq_joinNo START 1;

CREATE TABLE CHATROOMMESSAGE(
                                messageNo INTEGER PRIMARY KEY,
                                code VARCHAR(100) NOT NULL,
                                id VARCHAR(5000) NOT NULL,
                                receiver VARCHAR,
                                content VARCHAR(100) NOT NULL,
                                sendDate VARCHAR(100) NOT NULL,
                                roomNo INTEGER NOT NULL,

                                CONSTRAINT CHATROOM_FK FOREIGN KEY(roomNo) REFERENCES CHATROOM ON DELETE CASCADE
);

CREATE SEQUENCE seq_messageNo START 4;



