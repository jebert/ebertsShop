CREATE TABLE IF NOT EXISTS users (
    id uuid,
    user_name character varying(30) ,
    full_name character varying(120) ,
    password character varying(255),
    account_non_expired bit(1),
    account_non_locked bit(1),
    credentials_non_expired bit(1),
    enabled bit(1),
    CONSTRAINT pk_users_id PRIMARY KEY (id),
    CONSTRAINT uk_user_name UNIQUE (user_name)
    )
