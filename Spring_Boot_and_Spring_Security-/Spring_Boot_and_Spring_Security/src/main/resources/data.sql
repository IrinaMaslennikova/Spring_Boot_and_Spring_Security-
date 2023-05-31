INSERT INTO `users` (`id`, `username`, `firstname`, `lastname`, `password`, `Email`)
VALUES ('101', 'admin_test', 'admin', 'admin', '$2a$10$IMX8ArS1lYpEaiWLVG4z2uXUelP9BHHgQklcq8aLerJKmk9qn6HS.', '-');
--password admin

INSERT INTO `users` (`id`, `username`, `firstname`, `lastname`, `password`, `Email`)
VALUES ('102', 'user_test', 'user', 'user', '$2a$12$nFrjTD/jzyNROVIXhCrUKOoGEk5b3WgKVVfkSV709z4XFVfAtjjKu', '-');
--password user

INSERT INTO `roles` (`id`, `name`)
VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `roles` (`id`, `name`)
VALUES ('2', 'ROLE_USER');

INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES ('101', '1');
INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES ('102', '2');