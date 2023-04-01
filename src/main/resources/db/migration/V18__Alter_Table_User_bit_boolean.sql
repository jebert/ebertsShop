ALTER TABLE users ALTER account_non_expired TYPE bool USING account_non_expired::int::boolean;
ALTER TABLE users ALTER account_non_locked TYPE bool USING account_non_locked::int::boolean;
ALTER TABLE users ALTER credentials_non_expired TYPE bool USING credentials_non_expired::int::boolean;
ALTER TABLE users ALTER enabled TYPE bool USING enabled::int::boolean;