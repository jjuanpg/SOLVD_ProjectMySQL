package com.solvd.mybatis.connection;

import com.solvd.mybatis.mappers.*;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class ConnectionBuilder {

    public SqlSession buildConnection(){
        DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/supermarket", "root", "root");

        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(IBranchMapper.class);
        configuration.addMapper(ICustomerMapper.class);
        configuration.addMapper(IDeliveryMapper.class);
        configuration.addMapper(IDepartmentMapper.class);
        configuration.addMapper(IEmployeeMapper.class);
        configuration.addMapper(ILicenseMapper.class);
        configuration.addMapper(IManagerMapper.class);
        configuration.addMapper(IOrderMapper.class);
        configuration.addMapper(IProductMapper.class);
        configuration.addMapper(IPromoMapper.class);
        configuration.addMapper(IPurchaseMapper.class);
        configuration.addMapper(ISupplierMapper.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(configuration);

        return factory.openSession();
    }
}
