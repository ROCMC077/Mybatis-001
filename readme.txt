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
            要獲取 SqlSessionFactory對象, 需要先獲取 SqlSessionBuilder對象, 通過 SqlSessionBuilder對象的Build方法來獲取SqlSessionFactory對象

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
