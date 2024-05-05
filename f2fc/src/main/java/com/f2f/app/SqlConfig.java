package com.revengemission.sso.oauth2.server.f2f.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.nio.charset.Charset;

@Component
public class SqlConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext applicationContext;

    public void runSqlFile(String sqlFileName){
        Resource resource = applicationContext.getResource(sqlFileName);
        EncodedResource encodedResource = new EncodedResource(resource,Charset.forName("UTF-8"));
        try{
            ScriptUtils.executeSqlScript(dataSource.getConnection(),encodedResource);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
