USE [Feed]
GO
/****** Object:  Table [dbo].[RssChannels]    Script Date: 6/5/2017 11:30:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RssChannels](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Url] [varchar](200) NULL,
 CONSTRAINT [PK_RssChannels] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[RssChannels] ON 

INSERT [dbo].[RssChannels] ([Id], [Name], [Url]) VALUES (44, N'Unian', N'https://rss.unian.net/site/news_rus.rss')
INSERT [dbo].[RssChannels] ([Id], [Name], [Url]) VALUES (49, N'ЭкономикаЛига', N'http://news.liga.net/economics/rss.xml')
INSERT [dbo].[RssChannels] ([Id], [Name], [Url]) VALUES (50, N'КиевКор', N'http://k.img.com.ua/rss/ru/kyiv.xml')
INSERT [dbo].[RssChannels] ([Id], [Name], [Url]) VALUES (51, N'КультураРБК', N'https://www.rbc.ua/static/rss/ukrnet.culture.rus.rss.xml')
INSERT [dbo].[RssChannels] ([Id], [Name], [Url]) VALUES (52, N'Факты', N'http://fakty.ua/rss_feed/ukraina')
INSERT [dbo].[RssChannels] ([Id], [Name], [Url]) VALUES (53, N'УкраинскаяСтенаУкраина', N'https://ukrainianwall.com/ukraine/feed/')
INSERT [dbo].[RssChannels] ([Id], [Name], [Url]) VALUES (54, N'UNN Украина', N'http://www.unn.com.ua/rss/news_ru.xml')
SET IDENTITY_INSERT [dbo].[RssChannels] OFF
