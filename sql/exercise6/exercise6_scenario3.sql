DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;

    v_LoanID Loans.LoanID%TYPE;
    v_Rate Loans.InterestRate%TYPE;

BEGIN
    OPEN UpdateLoanInterestRates;

    LOOP
        FETCH UpdateLoanInterestRates
        INTO v_LoanID, v_Rate;

        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE CURRENT OF UpdateLoanInterestRates;
    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated successfully.');
END;
/