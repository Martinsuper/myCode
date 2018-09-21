import com.martind.editorBlog.Mapper.EditorBlogMapper;
import com.martind.editorBlog.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class myTest {

    @Test
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession opensession = sqlSessionFactory.openSession(true);
        try {
            EditorBlogMapper mapper = opensession.getMapper(EditorBlogMapper.class);
            User user = mapper.queryUser("yu");
            System.out.println(user);
        } finally {
            opensession.close();
        }
    }
}
