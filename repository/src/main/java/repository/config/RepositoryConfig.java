package repository.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import entity.User;
import entity.Vocabulary;
import entity.Word;
import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

/**
 * @author bbuallbest
 */
@Configuration
@ComponentScan("repository")
public class RepositoryConfig {

    @DependsOn("h2WebServer")
    @Bean(name = "h2TcpServer")
    public Server createH2TcpServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
    }

    @Bean(name = "h2WebServer")
    public Server createH2WebServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
    }

    private DatabasePopulator createDatabasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("db/create.sql"));
        return databasePopulator;
    }

    @DependsOn("h2TcpServer")
    @Bean(name = "dataSource")
    public DataSource getEmbeddedDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:mem:test;AUTO_RECONNECT=TRUE");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addAnnotatedClasses(Word.class,
                Vocabulary.class, User.class);
        sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return sessionBuilder.buildSessionFactory();
    }

}
