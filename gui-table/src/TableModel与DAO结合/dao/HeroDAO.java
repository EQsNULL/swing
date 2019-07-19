package TableModel与DAO结合.dao;

import TableModel与DAO结合.mapper.HeroMapper;
import TableModel与DAO结合.pojo.Hero;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HeroDAO {
    private static String resource;
    private static InputStream inputStream;
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession session;
    private static HeroMapper mapper;

    static {
        resource = "mybatis-config.xml";
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        mapper = session.getMapper(HeroMapper.class);
    }


    public static void add(Hero hero) {
        mapper.add(hero);
    }

    public static List<Hero> list() {
        return mapper.list();
    }

    public static void commitAndClose() {
        session.commit();
        session.close();
    }
}
