CREATE TABLE expense_reason(
    id UUID PRIMARY KEY NOT NULL,
    reason VARCHAR(100) UNIQUE NOT NULL
);

CREATE INDEX idx_expense_reasons_reason ON expense_reasons(reason);