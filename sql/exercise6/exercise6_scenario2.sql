DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;

    v_AccountID Accounts.AccountID%TYPE;
    v_Balance Accounts.Balance%TYPE;
    v_Fee NUMBER := 500;

BEGIN
    OPEN ApplyAnnualFee;

    LOOP
        FETCH ApplyAnnualFee
        INTO v_AccountID, v_Balance;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_Fee
        WHERE CURRENT OF ApplyAnnualFee;
    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual maintenance fee applied.');
END;
/