USE [master]
GO
/****** Object:  Database [GymManager]    Script Date: 10/30/2017 5:48:20 PM ******/
CREATE DATABASE [GymManager]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GymManager', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQL2012\MSSQL\DATA\GymManager.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'GymManager_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQL2012\MSSQL\DATA\GymManager_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [GymManager] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GymManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GymManager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GymManager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GymManager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GymManager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GymManager] SET ARITHABORT OFF 
GO
ALTER DATABASE [GymManager] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GymManager] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [GymManager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GymManager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GymManager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GymManager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GymManager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GymManager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GymManager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GymManager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GymManager] SET  DISABLE_BROKER 
GO
ALTER DATABASE [GymManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GymManager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GymManager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GymManager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GymManager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GymManager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GymManager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GymManager] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [GymManager] SET  MULTI_USER 
GO
ALTER DATABASE [GymManager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GymManager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GymManager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GymManager] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [GymManager]
GO
/****** Object:  Table [dbo].[bills]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bills](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[invoiceid] [int] NULL,
	[courseid] [int] NULL,
	[price] [int] NULL,
 CONSTRAINT [PK_invoices] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[course]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[course](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[time] [int] NULL,
	[price] [float] NULL,
	[description] [text] NULL,
 CONSTRAINT [PK_course] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[customer]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[phone] [int] NULL,
	[address] [text] NULL,
 CONSTRAINT [PK_customer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[funtionRole]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[funtionRole](
	[id] [int] NULL,
	[roleid] [tinyint] NULL,
	[funtionid] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[funtions]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[funtions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](50) NULL,
	[description] [text] NULL,
 CONSTRAINT [PK_funtions] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[invoices]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[invoices](
	[id] [int] NOT NULL,
	[userid] [int] NULL,
	[date] [datetime] NULL,
	[total] [int] NULL,
 CONSTRAINT [PK_invoiceid] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[roles]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [tinyint] IDENTITY(1,1) NOT NULL,
	[name] [nchar](50) NULL,
	[description] [text] NULL,
 CONSTRAINT [PK_roles] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[schedule]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[schedule](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[customerid] [int] NULL,
	[courseid] [int] NULL,
	[timeStart] [date] NULL,
	[timeEnd] [date] NULL,
	[careRegime] [text] NULL,
 CONSTRAINT [PK_schedule] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 10/30/2017 5:48:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userName] [nchar](50) NULL,
	[password] [nchar](50) NOT NULL,
	[roleid] [tinyint] NULL,
	[isActive] [bit] NULL,
	[address] [text] NULL,
	[phone] [nchar](13) NULL,
	[email] [varchar](30) NULL,
	[fullName] [nchar](50) NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[bills]  WITH CHECK ADD  CONSTRAINT [FK_bills_course] FOREIGN KEY([courseid])
REFERENCES [dbo].[course] ([id])
GO
ALTER TABLE [dbo].[bills] CHECK CONSTRAINT [FK_bills_course]
GO
ALTER TABLE [dbo].[bills]  WITH CHECK ADD  CONSTRAINT [FK_bills_invoiceid] FOREIGN KEY([id])
REFERENCES [dbo].[invoices] ([id])
GO
ALTER TABLE [dbo].[bills] CHECK CONSTRAINT [FK_bills_invoiceid]
GO
ALTER TABLE [dbo].[funtionRole]  WITH CHECK ADD  CONSTRAINT [FK_funtionRole_funtions] FOREIGN KEY([funtionid])
REFERENCES [dbo].[funtions] ([id])
GO
ALTER TABLE [dbo].[funtionRole] CHECK CONSTRAINT [FK_funtionRole_funtions]
GO
ALTER TABLE [dbo].[funtionRole]  WITH CHECK ADD  CONSTRAINT [FK_funtionRole_roles] FOREIGN KEY([roleid])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[funtionRole] CHECK CONSTRAINT [FK_funtionRole_roles]
GO
ALTER TABLE [dbo].[schedule]  WITH CHECK ADD  CONSTRAINT [FK_schedule_course] FOREIGN KEY([courseid])
REFERENCES [dbo].[course] ([id])
GO
ALTER TABLE [dbo].[schedule] CHECK CONSTRAINT [FK_schedule_course]
GO
ALTER TABLE [dbo].[schedule]  WITH CHECK ADD  CONSTRAINT [FK_schedule_customer] FOREIGN KEY([customerid])
REFERENCES [dbo].[customer] ([id])
GO
ALTER TABLE [dbo].[schedule] CHECK CONSTRAINT [FK_schedule_customer]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK_users_roles] FOREIGN KEY([roleid])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK_users_roles]
GO
USE [master]
GO
ALTER DATABASE [GymManager] SET  READ_WRITE 
GO
