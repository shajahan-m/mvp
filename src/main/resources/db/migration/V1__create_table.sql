CREATE TABLE public.m_user_role (
	id bigserial NOT NULL,
	"role" varchar(50) NULL,
	CONSTRAINT m_user_role_pk PRIMARY KEY (id)
);

CREATE TABLE public.m_user (
	id bigserial NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	email varchar(100) NULL,
	contact_no varchar(14) NULL,
	address text NULL,
	user_role_id int8 NULL,
	created_date_time timestamp NULL,
	last_updated_date_time timestamp NULL,
	status int4 NULL,
	CONSTRAINT m_user_pk PRIMARY KEY (id)
);

CREATE TABLE public.m_category (
	id bigserial NOT NULL,
	category_name varchar(255) NULL,
	created_date_time timestamp NULL,
	last_updated_date_time timestamp NULL,
	status int4 NULL,
	CONSTRAINT m_category_pk PRIMARY KEY (id)
);

CREATE TABLE public.m_post (
	id bigserial NOT NULL,
	title varchar(255) NULL,
	"content" text NULL,
	category_id int8 NULL,
	author_id int8 NULL,
	published_date timestamp NULL,
	tags text NULL,
	slug text NULL,
	likes_count int8 NULL DEFAULT 0,
	created_date_time timestamp NULL,
	last_updated_date_time timestamp NULL,
	status int4 NULL,
	CONSTRAINT m_post_pk PRIMARY KEY (id),
	CONSTRAINT m_post_un UNIQUE (slug),
	CONSTRAINT m_post_author_fk FOREIGN KEY (author_id) REFERENCES m_user(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT m_post_category_fk FOREIGN KEY (category_id) REFERENCES m_category(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE public.t_post_comment (
	id bigserial NOT NULL,
	"comment" text NULL,
	post_id int8 NULL,
	user_id int8 NULL,
	created_date_time timestamp NULL,
	last_updated_date_time timestamp NULL,
	status int4 NULL,
	CONSTRAINT t_post_comment_pk PRIMARY KEY (id),
	CONSTRAINT t_post_comment_post_fk FOREIGN KEY (post_id) REFERENCES m_post(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT t_post_comment_user_fk FOREIGN KEY (user_id) REFERENCES m_user(id) ON DELETE CASCADE ON UPDATE CASCADE
);