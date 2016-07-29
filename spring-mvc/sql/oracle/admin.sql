DEF username = insurance;

DECLARE
      v_count       INTEGER        := 0;
BEGIN
  
SELECT COUNT (1) INTO v_count FROM dba_users WHERE username = UPPER ('&username');
  
      IF v_count != 0
      THEN
         EXECUTE IMMEDIATE ('DROP USER &username CASCADE');
      END IF;
END;
/

CREATE USER insurance IDENTIFIED BY insurance;

grant connect to insurance;
grant all privileges to insurance;
