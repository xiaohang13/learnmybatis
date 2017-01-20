import com.nfmedia.mybatis.entries.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Description
 * <p>
 * Author rabbit.
 * Datetime 2017/1/21.
 */
public class TestStatement {

    private SqlSession sqlSession;

    @Before
    public void prepare() {
        String confName = "conf.xml";
        InputStream reader = TestUser.class.getClassLoader().getResourceAsStream(confName);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testAdd() {
        String statement = "com.nfmedia.mybatis.entries.UserMapper.addUser";
        int insert = sqlSession.insert(statement, new User(-1, "lucy", 21, "广州大道中289"));
        sqlSession.commit();
        System.out.println(insert);
    }

    @Test
    public void testDelete() {
        String statement = "com.nfmedia.mybatis.entries.UserMapper.deleteUser";
        int delete = sqlSession.delete(statement, 6);
        sqlSession.commit();
        System.out.println(delete);
    }

    @After
    public void after() {
        sqlSession.close();
    }
}
