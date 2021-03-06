CREATE TABLE USERS
(
  ID INTEGER NOT NULL,
  LOGIN VARCHAR(25),
  AUTH_TOKEN VARCHAR(25),
  PASS_HASH VARCHAR(25),
  PASS_SALT VARCHAR(25),
    PRIMARY KEY (ID)
);

CREATE TABLE VOCABULARIES
(
  ID INTEGER NOT NULL,
  NAME VARCHAR(25),
  DESCRIPTION VARCHAR(25),
  OWNER INTEGER,
    PRIMARY KEY (ID),
    FOREIGN KEY (OWNER)
      REFERENCES USERS(ID)
);

CREATE TABLE WORDS
(
  ID INTEGER NOT NULL,
  SOURCE VARCHAR(25),
  TRANSLATION VARCHAR(25),
  EXAMPLE VARCHAR(25),
  VOCABULARY INTEGER,
    PRIMARY KEY (ID),
    FOREIGN KEY (VOCABULARY)
      REFERENCES VOCABULARIES(ID)
);

