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
import org.h2.tools.RunScript;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Objects;

import static ge.tbc.testautomation.Constants.*;

public class DataBaseConfig {
    public static UsersMapper dbMapper() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);

        try (Connection conn = dataSource.getConnection()) {

            InputStreamReader reader = new InputStreamReader(
                    Objects.requireNonNull(DataBaseConfig.class
                            .getClassLoader()
                            .getResourceAsStream("sql/users.sql"))
            );
            RunScript.execute(conn, reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment(DEVELOPMENT, transactionFactory, dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UsersMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        return sqlSession.getMapper(UsersMapper.class);
    }
}