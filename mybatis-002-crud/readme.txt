使用mybatis完成crud

    1.在 JDBC sql語句
        是用 ? 代表要插入的數值
        insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values (null,?,?,?,?,?)

    2.在 mybatis sql語句是
        是用 #{} 代表要插入的數值
        insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values (null,#{},#{},#{},#{},#{})

        java中使用 Map 可以給Sql語句中 佔位符 傳值
            Map<String,Object> object = new HashMap<>();
            object.put("k1","111");
            object.put("k2","特斯拉");
            object.put("k3",3000);
            object.put("k4","2024-08-10");
            object.put("k5","電車");

            insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values (null,#{k1},#{k2},#{k3},#{k4},#{k5})
            注意: #{這裡面寫 Map 集合中的 Key, 如果key不存在, 獲取的會是null}

        java中使用POJO給sql語句的佔位符傳值
            Car car = new Car(null,"1005","奧迪",200.0,"2024-08-10","油車");
            注意: #{}, 大括號裡寫 POJO 類的屬性名
            insert into t_car(id,car_num,brand,guide_price,produce_time,car_type)
            values (null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType});

        mybatis底層給?傳值的時候, 要先獲取值
            調用pojo對象get方法, 例如car.getCarNum(), car.getCarType()...etc

    3.delete
        int count = sqlSession.delete("deleteById", 19);

        <delete id="deleteById">
            delete from t_car where id = #{id}
        </delete>
        *注意: 如果佔位符只有一個, #{}裡面可以隨便寫

    4.update
        <update id="updateById">
           update t_car set
                car_num = #{carNum},
                brand=#{brand},
                guide_price=${guide_price},
                produce_time=#{produce_time},
                car_type=#{car_type}
           where id = #{id}
        </update>

        Car car = new Car(1,"1000","BMW_update",200.0,"2024-08-10","油車Update");
        int count = sqlSession.delete("updateById", car);

    5.select (一個)
        <select id="selectById" resultType="com.practice.mybatis.pojo.Car">
            select * from t_car where id = #{id};
        </select>

        Object car = sqlSession.selectOne("selectById", 1);

            輸出結果:Car{id=1, carNum='null', brand='BMW_update', guide_price=200.0, produce_time='2024-08-10', car_type='油車Update'}
              問題 :carNum是null的原因是 因為資料庫中的欄位名 跟 POJO的屬性名不一致
            解決辦法:用 as 去更改欄位名
                   select
                        id,
                        car_num as carNum,
                        brand,
                        guide_price,
                        produce_time,
                        car_type
                   from
                        t_car
                   where
                        id = #{id};
        注意: select 標籤中 resultType 屬性用來告訴 Mybatis, 查詢結果集封裝成甚麼類型的java對象


    6.select (List)
         <select id="selectAll" resultType="com.practice.mybatis.pojo.Car">
            <!--select * from t_car where id = #{id};-->
            select
            id,
            car_num as carNum,
            brand,
            guide_price,
            produce_time,
            car_type
            from
            t_car
         </select>

         List<Object> cars = sqlSession.selectList("selectAll");
         cars.forEach(car -> System.out.println(car));

         注意: resultType還是要指定封裝結果集的類型, 不是指定List類型, 是指定 List集合中元素的類型
              selectList方法: mybatis通過這方法就可以判斷你需要的是一個 List集合

    7.在sql mapper.xml文件當中有一個namespace, 這個屬性是為了指定命名空間, 防止id重複

        在xml文件當中
            <mapper namespace="xxxxxx">
                <select id="selectAll" resultType="com.practice.mybatis.pojo.Car">
                    select * from t_car
                </select>
            </mapper>

        在java程序中
           List<Object> cars = sqlSession.selectList("xxxxxx.selectAll");

        實質上,在mybatis中的sqlId的完整寫法
            namespace.id




