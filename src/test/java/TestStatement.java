import com.nfmedia.mybatis.entries.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

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

    @Test
    public void testUpdate() {
        String statement = "com.nfmedia.mybatis.entries.UserMapper.updateUser";
        int update = sqlSession.update(statement, new User(8, "randy", 18, "上海虹桥"));
        sqlSession.commit();
        System.out.println(update);
    }

    @Test
    public void testGetAll() {
        String statement = "com.nfmedia.mybatis.entries.UserMapper.getUserList";
        List<User> userList = sqlSession.selectList(statement);
        System.out.println(userList);
    }

    @After
    public void after() {
        sqlSession.close();
    }
}
