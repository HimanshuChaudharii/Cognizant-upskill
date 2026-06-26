DECLARE
BEGIN
    FOR cust IN (
        SELECT CustomerID, Age
        FROM Customers
    ) LOOP
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/