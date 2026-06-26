-- Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers(Customer_ID, Name, Balance)
        VALUES (p_customer_id, p_name, p_balance);
    END;

    PROCEDURE UpdateCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance
        WHERE Customer_ID = p_customer_id;
    END;

    FUNCTION GetCustomerBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE Customer_ID = p_customer_id;

        RETURN v_balance;
    END;

END CustomerManagement;
/