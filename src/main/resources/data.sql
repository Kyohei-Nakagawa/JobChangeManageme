insert into projects (status, agent, company, title, programming, detail, uptime, register)
values ('waiting', 'typeagent', 'companyA', 'titleA', 'programmingA', 'detailA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into projects (status, agent, company, title, programming, detail, uptime, register)
values ('interview', 'levtech', 'companyB', 'titleB', 'programmingB', 'detailB', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into users (mail, password, agent, company, authority, register)
values ('k.nakagawa.0426@outlook.jp', 'kyohei', NULL, NULL, 'OWNER', CURRENT_TIMESTAMP());

insert into users (mail, password, agent, company, authority, register)
values ('k.nakagawa.0426@gmail.com', 'kyohei2', 'levtech', NULL, 'OWNER', CURRENT_TIMESTAMP());