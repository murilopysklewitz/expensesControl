CREATE TABLE Expenses(
    id UUID PRIMARY KEY NOT NULL,
    who VARCHAR(20) NOT NULL,
    amount NUMERIC(19,2) NOT NULL,
    reason_id UUID NOT NULL ,
    description VARCHAR(255),
    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_expenses_reasons
        FOREIGN KEY (reason_id) REFERENCES expense_reasons(id)
);


CREATE INDEX idx_expenses_who ON Expenses(who);
CREATE INDEX idx_expenses_reason_id ON Expenses(reason_id);
CREATE INDEX idx_expenses_amount ON Expenses(amount);
CREATE INDEX idx_expenses_who_reason ON Expenses(who, reason_id);
CREATE INDEX idx_expenses_created_at ON Expenses(created_at DESC);
