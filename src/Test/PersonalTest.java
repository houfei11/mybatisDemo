import com.csdn.demo.dao.PersonalDao;
import com.csdn.demo.entity.Personal;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;

public class PersonalTest {

    @Test
    public void personalFindByIdTest(){

        /**
         * 定义读取文件名
         */
        String resources = "mybatis-config.xml";

        // 创建流
        Reader reader = null;

        try {
            // 读取mybatis-config.xml文件到reader对象中
            reader = Resources.getResourceAsReader(resources);
        }catch (IOException e){
            e.printStackTrace();
        }

        //初始化mybatis，创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

        //创建Session实例
        SqlSession session = sqlMapper.openSession();
        //传入参数，返回结果
        Personal personal = session.selectOne("com.csdn.demo.entity.Personal", 3);
        System.out.println(personal.toString());

        //关闭session
        session.close();
    }

    public SqlSessionFactory getSqlSessionFactory()throws IOException{

        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test02() throws IOException {
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try{

            //获取接口的实现类对象
            PersonalDao mapper = openSession.getMapper(PersonalDao.class);
            Personal personal = mapper.getPersonalById(3);
            System.out.println(personal.toString());
        }finally{
            openSession.close();
        }
    }

    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            PersonalDao mapper = openSession.getMapper(PersonalDao.class);

            //添加
            Personal personal = new Personal(2, "找不到", 18, "斯坦福", new Date(2019-03-05));
            mapper.addPersonal(personal);

            //修改
            Personal personal1 = new Personal(3, "wangming", 6, "师范大学", new Date(2019-03-05));
            mapper.updatePersonal(personal1);

            //删除
            mapper.deletePersonal(4);

            openSession.commit();

        }finally {
            openSession.close();
        }


    }
}
