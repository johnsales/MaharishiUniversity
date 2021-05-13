-- script valid for postgresql, user: user, password: pass
INSERT INTO users (username, password, enabled)
  values ('user',
    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
    1) ON CONFLICT (username) do nothing;

INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_ADMIN') ON CONFLICT (username, authority) do nothing;