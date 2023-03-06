CREATE TABLE IF NOT EXISTS user_permission (
  id_user uuid,
  id_permission uuid,
  CONSTRAINT pk_id_permissions UNIQUE (id_user, id_permission),
  CONSTRAINT fk_user_permission FOREIGN KEY (id_user) REFERENCES users (id),
  CONSTRAINT fk_user_permission_permission FOREIGN KEY (id_permission) REFERENCES permission (id)
)