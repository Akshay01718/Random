-- Table Creation
CREATE TABLE acc (
    acno NUMBER PRIMARY KEY, 
    bal NUMBER
);

-- Insert Sample Data
INSERT INTO acc VALUES (1, 10000);
INSERT INTO acc VALUES (2, 60000);
INSERT INTO acc VALUES (3, 12000);
INSERT INTO acc VALUES (4, 45000);

-- Debit Procedure
CREATE OR REPLACE PROCEDURE debit(p_acno IN NUMBER, p_debit_amount IN NUMBER) AS
    current_balance NUMBER;
    new_balance NUMBER;
    min_balance CONSTANT NUMBER := 500;
BEGIN
    SELECT bal INTO current_balance FROM acc WHERE acno = p_acno;
    
    IF current_balance - p_debit_amount < min_balance THEN
        DBMS_OUTPUT.PUT_LINE('Insufficient balance to debit ' || min_balance || ' from the account ' || p_acno);
    ELSE
        UPDATE acc SET bal = current_balance - p_debit_amount WHERE acno = p_acno;
        DBMS_OUTPUT.PUT_LINE('Amount has been debited.');
        
        SELECT bal INTO new_balance FROM acc WHERE acno = p_acno;
        DBMS_OUTPUT.PUT_LINE('Latest Updated BANK BALANCE: ' || new_balance);
    END IF;
END;
/

-- Credit Procedure
CREATE OR REPLACE PROCEDURE credit(p_acno IN NUMBER, p_credit_amount IN NUMBER) AS
    current_balance NUMBER;
    new_balance NUMBER;
    max_balance CONSTANT NUMBER := 30000;
BEGIN
    SELECT bal INTO current_balance FROM acc WHERE acno = p_acno;
    
    IF current_balance + p_credit_amount > max_balance THEN
        DBMS_OUTPUT.PUT_LINE('Exceeded Banking Limit of ' || max_balance || ' for the account ' || p_acno);
    ELSE
        UPDATE acc SET bal = current_balance + p_credit_amount WHERE acno = p_acno;
        DBMS_OUTPUT.PUT_LINE('Amount has been credited.');
        
        SELECT bal INTO new_balance FROM acc WHERE acno = p_acno;
        DBMS_OUTPUT.PUT_LINE('Latest Updated BANK BALANCE after credit: ' || new_balance);
    END IF;
END;
/

-- Function to Determine Account Category
CREATE OR REPLACE FUNCTION acc_category(amount IN NUMBER) RETURN VARCHAR2 IS
    category VARCHAR2(30);
BEGIN
    IF amount > 50000 THEN
        category := 'Platinum';
    ELSIF amount > 10000 AND amount <= 50000 THEN
        category := 'Gold';
    ELSE
        category := 'Silver';
    END IF;
    RETURN category;
END;
/

-- Show Balance Procedure
CREATE OR REPLACE PROCEDURE show_balance(p_acno IN NUMBER) AS
    present_balance NUMBER;
BEGIN
    SELECT bal INTO present_balance FROM acc WHERE acno = p_acno;
    DBMS_OUTPUT.PUT_LINE('BANK BALANCE of the account ' || p_acno || ' is ' || present_balance);
    DBMS_OUTPUT.PUT_LINE('Account Category: ' || acc_category(present_balance));
END;
/

-- Main Execution Block
DECLARE
    v_acno NUMBER := &account;
    v_amount NUMBER := &amount;
    ch NUMBER := &choice;
BEGIN
    IF ch = 1 THEN
        debit(v_acno, v_amount);
        show_balance(v_acno);
    ELSIF ch = 2 THEN
        credit(v_acno, v_amount);
        show_balance(v_acno);
    ELSIF ch = 3 THEN
        show_balance(v_acno);
    END IF;
END;
/
