CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
)
RETURN NUMBER
IS
    v_MonthlyRate NUMBER;
    v_Months NUMBER;
    v_EMI NUMBER;
BEGIN
    v_MonthlyRate := (p_InterestRate / 100) / 12;
    v_Months := p_DurationYears * 12;

    v_EMI := (p_LoanAmount * v_MonthlyRate *
             POWER(1 + v_MonthlyRate, v_Months))
             /
             (POWER(1 + v_MonthlyRate, v_Months) - 1);

    RETURN ROUND(v_EMI, 2);
END;
/