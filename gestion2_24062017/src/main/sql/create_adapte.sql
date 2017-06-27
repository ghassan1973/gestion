-- replace NUMBER par DECIMAL
-- replace order_fk by order_fk1 in "alter table tbl_transaction add constraint order_fk1"

-- OK CREATE DATABASE app_gestion2 DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
-- KO CREATE SCHEMA `app_gestion2` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

use app_gestion2;

create table tbl_user(user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,first_name VARCHAR(255),last_name VARCHAR(255),email VARCHAR(255),password VARCHAR(255));

create table tbl_role(role_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,role_name VARCHAR(255));

create table tbl_permission(permission_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,permission_name VARCHAR(255));

create table tbl_family(family_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,family_name VARCHAR(255));

create table tbl_product(product_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,product_name VARCHAR(255),unit_price DECIMAL(20,10),tva1 VARCHAR(255),tva2 VARCHAR(255),family_id BIGINT);

create table tbl_mode_payment(mode_payment_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,mode_payment_name VARCHAR(255));

create table tbl_currency(currency_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,currency_name VARCHAR(255));

create table tbl_project_type(project_type_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,project_type_name VARCHAR(255));

create table tbl_region(region_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,region_name VARCHAR(255));

create table tbl_project_status(project_status_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,project_status_name VARCHAR(255));

create table tbl_project(project_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,project_name VARCHAR(255),start_date DATETIME,end_date DATETIME,cost DECIMAL(20,10),sale DECIMAL(20,10),rest_to_pay DECIMAL(20,10),margin DECIMAL(20,10),region_id BIGINT,projectType_id BIGINT,projectStatus_id BIGINT);

create table tbl_order(order_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,order_name VARCHAR(255),date DATETIME,amount DECIMAL(20,10),total_settlement DECIMAL(20,10),balance DECIMAL(20,10),project_id BIGINT,tier_id BIGINT);

create table tbl_family_tier(family_tier_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,family_tier_name VARCHAR(255));

create table tbl_tier(tier_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,tier_name VARCHAR(255),address1 VARCHAR(255),address2 VARCHAR(255),mobile VARCHAR(255),phone VARCHAR(255),email VARCHAR(255),familyTier_id BIGINT);

create table tbl_order_lines(order_lines_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,order_lines_name VARCHAR(255),quantity DECIMAL(20,10),unit_price DECIMAL(20,10),discount VARCHAR(255),comment VARCHAR(255),product_id BIGINT,order_id BIGINT);

create table tbl_transaction(transaction_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,transaction_name VARCHAR(255),date DATETIME,amount DECIMAL(20,10),piece_num VARCHAR(255),comment VARCHAR(255),in_out VARCHAR(255),order_id BIGINT,currency_id BIGINT,modePayment_id BIGINT);

-- Association Table
create table tbl_user_role_assoc(user_id BIGINT NOT NULL,role_id BIGINT NOT NULL);
create table tbl_role_permission_assoc(role_id BIGINT NOT NULL,permission_id BIGINT NOT NULL);
-- Alter table for foreign key




alter table tbl_product add constraint family_fk foreign key (family_id) REFERENCES tbl_family(family_id);






alter table tbl_project add constraint region_fk foreign key (region_id) REFERENCES tbl_region(region_id);
alter table tbl_project add constraint projectType_fk foreign key (projectType_id) REFERENCES tbl_project_type(project_type_id);
alter table tbl_project add constraint projectStatus_fk foreign key (projectStatus_id) REFERENCES tbl_project_status(project_status_id);

alter table tbl_order add constraint project_fk foreign key (project_id) REFERENCES tbl_project(project_id);
alter table tbl_order add constraint tier_fk foreign key (tier_id) REFERENCES tbl_tier(tier_id);


alter table tbl_tier add constraint familyTier_fk foreign key (familyTier_id) REFERENCES tbl_family_tier(family_tier_id);

alter table tbl_order_lines add constraint product_fk foreign key (product_id) REFERENCES tbl_product(product_id);
alter table tbl_order_lines add constraint order_fk foreign key (order_id) REFERENCES tbl_order(order_id);

alter table tbl_transaction add constraint order_fk1 foreign key (order_id) REFERENCES tbl_order(order_id);
alter table tbl_transaction add constraint currency_fk foreign key (currency_id) REFERENCES tbl_currency(currency_id);
alter table tbl_transaction add constraint modePayment_fk foreign key (modePayment_id) REFERENCES tbl_mode_payment(mode_payment_id);


CREATE TABLE `forgot_password_request` (
`request_id` bigint(20) NOT NULL AUTO_INCREMENT,
`user_id` bigint(20) DEFAULT NULL,
`token_id` varchar(255) DEFAULT NULL,
`expires_on` datetime DEFAULT NULL,
`created_on` datetime DEFAULT NULL,
PRIMARY KEY (`request_id`)
);

CREATE TABLE `persistent_logins` (
`username` varchar(64) NOT NULL,
`series` varchar(64) NOT NULL,
`token` varchar(64) NOT NULL,
`last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`series`)
);

CREATE TABLE `signup_request` (
`request_id` bigint(20) NOT NULL AUTO_INCREMENT,
`user_id` bigint(20) DEFAULT NULL,
`token_id` varchar(255) DEFAULT NULL,
`expires_on` datetime DEFAULT NULL,
`created_on` datetime DEFAULT NULL,
PRIMARY KEY (`request_id`)
);


insert into tbl_user(first_name,last_name,email,password) values ('Admin','User','admin@example.com','admin');


 CREATE OR replace VIEW reportallout AS SELECT tr.in_out, p.project_name,t.tier_name,o.order_name,format(COALESCE(o.amount,0),2) AS Credit,format(COALESCE(sum(tr.amount),0),2) AS Debt, format(COALESCE(o.amount,0)-sum(COALESCE(tr.amount,0)),2) AS Balance,tr.date, p.project_id, t.tier_id,o.order_id FROM tbl_project as p, tbl_tier as t,tbl_family_tier as ft, tbl_order as o , tbl_transaction as tr where tr.order_id=o.order_id and tr.in_out='Out (Payment)' and ft.family_tier_id=t.family_tier_id and p.project_id=o.project_id and t.tier_id=o.tier_id group by  o.order_id;
 CREATE OR replace VIEW reportallin AS SELECT tr.in_out,p.project_name,t.tier_name,o.order_name, format(COALESCE(sum(tr.amount),0),2) AS Credit,format(COALESCE(o.amount,0),2) AS Debt, format(sum(COALESCE(tr.amount,0))-COALESCE(o.amount,0),2) AS Balance,tr.date, p.project_id, t.tier_id,o.order_id FROM tbl_project as p, tbl_tier as t,tbl_family_tier as ft, tbl_order as o, tbl_transaction as tr where in_out='In (Take)' and ft.family_tier_id=t.family_tier_id and tr.order_id=o.order_id and p.project_id=o.project_id and t.tier_id=o.tier_id group by o.order_name;
