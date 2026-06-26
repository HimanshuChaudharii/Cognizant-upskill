CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerId IN NUMBER,
    p_customerName IN VARCHAR2,
    p_balance IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers(CustomerID, CustomerName, Balance)
    VALUES (p_customerId, p_customerName, p_balance);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer Added Successfully');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/