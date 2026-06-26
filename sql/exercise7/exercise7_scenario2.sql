-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    );

    PROCEDURE UpdateEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_emp_id NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    ) IS
    BEGIN
        INSERT INTO Employees(Employee_ID, Name, Salary)
        VALUES (p_emp_id, p_name, p_salary);
    END;

    PROCEDURE UpdateEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Salary = p_salary
        WHERE Employee_ID = p_emp_id;
    END;

    FUNCTION CalculateAnnualSalary(
        p_emp_id NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE Employee_ID = p_emp_id;

        RETURN v_salary * 12;
    END;

END EmployeeManagement;
/