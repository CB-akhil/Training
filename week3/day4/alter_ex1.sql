alter table marks add created_at TIMESTAMP NOT NULL default now(),add updated_at TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW();

alter table students add created_at TIMESTAMP NOT NULL default now(),add updated_at TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW();

alter table medals add created_at TIMESTAMP NOT NULL default now(),add updated_at TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW();