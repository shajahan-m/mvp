INSERT INTO m_user_role (id,"role") VALUES
	 (1,'Admin'),
	 (2,'Public User');
	 INSERT INTO m_user (id,first_name,last_name,email,contact_no,address,user_role_id,created_date_time,last_updated_date_time,status) VALUES
	 (1,'William','David','david@gmail.com','5159187178','Des Moines',1,'2023-06-07 01:01:01','2023-06-07 01:01:01',1),
	 (2,'Daniel','Benjamin','benjamin@gmail.com','8184144179','Canoga Park',2,'2023-06-07 01:01:01','2023-06-07 01:01:01',1),
	 (3,'Samuel','Henry','henry@gmail.com','6085169210','Madison',2,'2023-06-07 01:01:01','2023-06-07 01:01:01',1);
	 
	 INSERT INTO m_category (id,category_name,created_date_time,last_updated_date_time,status) VALUES
	 (1,'Cricket','2023-06-07 01:01:01','2023-06-07 01:01:01',1),
	 (2,'Footbal','2023-06-07 01:01:01','2023-06-07 01:01:01',1);
	 
	 INSERT INTO m_post (id,title,"content",category_id,author_id,published_date,tags,slug,likes_count,created_date_time,last_updated_date_time,status) VALUES
	 (2,'Epic Rivalries: The Intensity and Drama that Ignite Sports','Here, we delve into the world of rivalries that transcend the boundaries of mere competition. From historic clashes between teams and athletes to heated battles on the field, we explore the intense rivalries that fuel the passion of fans worldwide. Through iconic moments, unforgettable matches, and the stories behind the animosity, we capture the essence of these captivating duels.',1,3,NULL,'Sport,Cricket','epic-rivalries',0,'2023-06-05 01:01:01','2023-06-07 01:01:01',0),
	 (1,'Unforgettable Moments: Reliving the Triumphs and Trials of Sports','In the realm of sports, each day brings forth a captivating tapestry of thrilling victories, heart-wrenching defeats, and extraordinary displays of athleticism. In this sports blog post, we delve into the diverse and dynamic world of sports, celebrating the unforgettable moments that have enthralled fans across the globe',1,2,NULL,'Sports,Cricket','unforgettable-moments',0,'2023-06-04 01:01:01','2023-06-07 01:01:01',0);
	 
	 INSERT INTO t_post_comment (id,"comment",post_id,user_id,created_date_time,last_updated_date_time,status) VALUES
	 (1,'Good',1,3,'2023-06-04 01:01:01','2023-06-07 01:01:01',1);
	 
	 