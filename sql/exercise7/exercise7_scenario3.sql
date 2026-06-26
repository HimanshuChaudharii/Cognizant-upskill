-- Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts(Account_ID, Customer_ID, Balance)
        VALUES (p_account_id, p_customer_id, p_balance);
    END;

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE Account_ID = p_account_id;
    END;

    FUNCTION GetTotalBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE Customer_ID = p_customer_id;

        RETURN NVL(v_total, 0);
    END;

END AccountOperations;
/