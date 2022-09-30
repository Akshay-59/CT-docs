
-- create db shopping
create database shopping

-- create user_tbl
USE [shopping]
GO

/****** Object:  Table [dbo].[user_tbl]    Script Date: 10-04-2022 16:21:35 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_tbl](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](100) NULL,
	[password] [varchar](100) NULL,
	[role] [varchar](100) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO



-- create order_details_tbl
USE [shopping]
GO

/****** Object:  Table [dbo].[order_details_tbl]    Script Date: 10-04-2022 16:20:59 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[order_details_tbl](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
	[category_id] [int] NULL,
	[product_id] [int] NULL,
	[quantity] [int] NULL,
	[total] [float] NULL,
PRIMARY KEY CLUSTERED
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

-- create category_tbl
USE [shopping]
GO

/****** Object:  Table [dbo].[category_tbl]    Script Date: 10-04-2022 16:18:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[category_tbl](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

-- create product_tbl
USE [shopping]
GO

/****** Object:  Table [dbo].[product_tbl]    Script Date: 10-04-2022 16:21:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[product_tbl](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NULL,
	[price] [float] NULL,
	[category_id] [int] NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[product_tbl]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[category_tbl] ([id])
GO



-- insert some basic values
insert into user_tbl values ('sagar','12345','customer')
insert into user_tbl values ('yash','password','admin')


insert into category_tbl values ('Mobiles')
insert into category_tbl values ('Laptops')
insert into category_tbl values ('Fashion')
insert into category_tbl values ('Grocery')


insert into product_tbl values ('Iphone 12',45000,1)
insert into product_tbl values ('Iphone 13',65000,1)
insert into product_tbl values ('Samsung galaxy S22',55000,1)


insert into product_tbl values ('Dell XPS',50000,2)
insert into product_tbl values ('Lenovo Ideapad',66000,2)
insert into product_tbl values ('Macbook Air',76000,2)


insert into product_tbl values ('Gucci Belt',10000,3)
insert into product_tbl values ('Highlander Jacket',5000,3)
insert into product_tbl values ('Sketchers shoes',8000,3)


insert into product_tbl values ('Amul cheese (1 kg) ',500,4)
insert into product_tbl values ('Amul butter (1 kg)',600,4)
insert into product_tbl values ('Bread Loaf',80,4)
