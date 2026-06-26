SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT CustomerID,
               TransactionID,
               TransactionType,
               Amount,
               TransactionDate
        FROM Transactions
        WHERE TRUNC(TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');

    v_CustomerID Transactions.CustomerID%TYPE;
    v_TransactionID Transactions.TransactionID%TYPE;
    v_Type Transactions.TransactionType%TYPE;
    v_Amount Transactions.Amount%TYPE;
    v_Date Transactions.TransactionDate%TYPE;

BEGIN
    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements
        INTO v_CustomerID, v_TransactionID, v_Type, v_Amount, v_Date;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_CustomerID ||
            ', Transaction: ' || v_TransactionID ||
            ', Type: ' || v_Type ||
            ', Amount: ' || v_Amount ||
            ', Date: ' || TO_CHAR(v_Date, 'DD-MON-YYYY')
        );
    END LOOP;

    CLOSE GenerateMonthlyStatements;
END;
/