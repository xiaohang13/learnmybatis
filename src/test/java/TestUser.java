import com.nfmedia.mybatis.entries.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Description
 * <p>
 * Author rabbit.
 * Datetime 2017/1/19.
 */
public class TestUser {
    public static void main(String[] args) {
        String confName = "conf.xml";
        InputStream reader = TestUser.class.getClassLoader().getResourceAsStream(confName);
        System.out.println(reader);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        // 映射sql标识串
        String statement = "com.nfmedia.mybatis.entries.UserMapper.getUser";
        User user = sqlSession.selectOne(statement,1);
        System.out.println(user);
    }
}
