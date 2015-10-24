DROP SEQUENCE tts_s_track_id;
DROP TABLE tts_track;

CREATE SEQUENCE tts_s_track_id START 101;

CREATE TABLE tts_track (
	id bigint NOT NULL,
	user_id bigint DEFAULT NULL,
	task_id bigint NOT NULL DEFAULT '0',
	status varchar(100) NOT NULL DEFAULT '',
	change_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);