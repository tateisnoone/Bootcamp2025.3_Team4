package ge.tbc.testautomation.config;

import ge.tbc.testautomation.db.UsersMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import static ge.tbc.testautomation.Constants.*;

public class DataBaseConfig {
    public static UsersMapper dbMapper() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment(DEVELOPMENT, transactionFactory, dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UsersMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        return sqlSession.getMapper(UsersMapper.class);
    }
}