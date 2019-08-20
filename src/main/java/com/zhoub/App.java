package com.zhoub;

import com.zhoub.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.io.InputStream;

public class App {
    public static void main( String[] args ) {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resourse = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resourse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //增加学生
        Student student1 = new Student();
        student1.setStudentID(199);
        student1.setId(9);
        student1.setName("新增的学生");
        sqlSession.insert("addStudent", student1);

        //删除学生
        Student student2 = new Student();
        student2.setId(1);
        sqlSession.delete("deleteStudent", student2);

        //修改学生姓名
        Student student3 = new Student();
        student3.setId(5);
        student3.setName("修改的学生");
        sqlSession.update("updateStudent", student3);

        //根据id查询学生
        Student student4 = sqlSession.selectOne("getStudent",9);

        // 最后再通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> studentList = sqlSession.selectList("listStudent");
        for (Student student : studentList) {
            System.out.println("ID:" + student.getId() + ", NAME:" + student.getName());
        }
        System.out.println();

        System.out.println("ID:" + student4.getId() + ", STUDENTID:" + student4.getStudentID()
                + ", NAME:" + student4.getName());

        // 提交修改
        sqlSession.commit();
        // 关闭 session
        sqlSession.close();
    }
}
