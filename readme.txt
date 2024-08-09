開發Mybatis (https://mybatis.net.cn/getting-started.html)

1.開發步驟
    (1)打包方式jar

    (2)引入依賴
        -mybatis
        -mysql

    (3)編寫mybatis配置文件,mybatis-config.xml
        第一:名稱可以自己取 mybatis-config.xml(默認)
        第二:文件存放位置也不是固定，默認會放到類的根目錄

    (4)編寫XxxMapper.xml文件
        在這配置中編寫sql語句
        文件名、位置都不是固定的

    (5)在 Mybatis-config.xml文件中指定 XxxMapper.xml路徑:
        <mapper resource="CarMapper.xml"/>
        注意:resource屬性會自動從類的根目錄下開始查找資源

    (6)編寫Mybatis (使用Mybatis的類庫,編寫mybatis連接數據庫做增刪改查)
        在Mybatis中負責執行SQL語句的對象叫 SqlSession
        SqlSession是專門用來執行SQL, 是一個Java程式和資料庫之間的一次會話
            要獲取 SqlSession, 需要先獲取 SqlSessionFactory對象, 通過 SqlSessionFactory工廠來產生
            要獲取 SqlSessionFactory對象, 需要先獲取 SqlSessionBuilder對象, 通過 SqlSessionFactoryBuilder對象的Build方法來獲取SqlSessionFactory對象

        Mybatis的核心對象包括
            SqlSessionFactoryBuilder
            SqlSessionFactory
            SqlSession
            ( SqlSessionBuilder.build 建立 SqlSessionFactory 再建立 SqlSession )


2.從 XML 中構建 SqlSessionFactory

3.mybatis中有兩個重要文件
    1. mybatis-config.xml 核心配置文件,配置連接資料庫的訊息 (一個)
    2. XxxxMapper.xml 專門用來編寫SQL語句的配置文件 (一張表一個)
        t_user表, 一般對應一個UserMapper.xml
        t-student表, 一般對應一個StudentMapper.xml

4.小細節
    *mybatis中的sql語句結尾 ; 可加可不加
    *Resources.getResourceAsStream
        小技巧: 以後遇到resource這個單字, 大部分都是從類的根目錄下開始查找

5.關於Mtbatis集成日誌組件, 讓我們調試更方便,
    *myBatis常見的集成日誌組件
        SLF4J :是一個日誌標準,其中又一個框架叫 logback,他實現SLF4J規範
        LOG4J
        LOG4J2
        STDOUT_LOGGING...etc

        注意: log4j log4j2 logback 都是同一作者開發

    *其中 STDOUT_LOGGING 是標準日誌, mybaits框架已經實現了這種標準日誌
     只要開啟即可, 在 mybatis-config.xml文件中使用 setting 標籤進行配置開啟
         <settings>
             <setting name="logImpl" value="STDOUT_LOGGING"/>
         </settings>
     這標籤在編寫的時候要注意, 他應該出現在 environments標籤之前, 注意順序
     因為有dtd文件進行約束, 只要參考dtd約束即可, 不用特別記

     這種實現也是可以的,可以看到一些訊息, 比如: 連接對象甚麼時候創建, 甚麼時候關閉, sql語句是怎樣

   *集成 logback日誌框架‧
    logback日誌框架實現slf4j標準
    第一步:引入logback的依賴
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.4.14</version>
        </dependency>
    第二步:引入logback所必需的xml配置文件
        這個配置文件名必須叫做: logback.xml 或 logback-test.xml
        這個配置文件必須放在類的根目錄下