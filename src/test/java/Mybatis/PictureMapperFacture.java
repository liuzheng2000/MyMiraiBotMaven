package Mybatis;

import org.apache.ibatis.session.SqlSession;

public class PictureMapperFacture {
    public static void main(String[] args) {
        try (SqlSession session = edu.qingyun.Mapper.MapperFacture.sqlSessionFactory.openSession()) {
            // 你的应用逻辑代码
        }
    }
}
