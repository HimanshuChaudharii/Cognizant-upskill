CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        TransactionID,
        AccountID,
        TransactionType,
        Amount,
        LogDate
    )
    VALUES (
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.TransactionType,
        :NEW.Amount,
        SYSDATE
    );
END;
/