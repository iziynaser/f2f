package com.f2f.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DataLoaderService {
    private final DataSource dataSource;
    private final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    public DataLoaderService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void loadSqlFolder(String folderName) throws IOException, SQLException {
        String pathPattern = "classpath:sql/" + folderName + "/*.sql";

        Resource[] resources = resolver.getResources(pathPattern);
        if (resources.length == 0) {
            throw new IOException("No SQL files found in folder " + folderName);
        }

        try (Connection connection = dataSource.getConnection()) {
            for (Resource resource : resources) {
                ScriptUtils.executeSqlScript(connection, resource);
            }
        }
    }

    public void loadSqlFile(String folderName,String fileName) throws IOException,SQLException{
        String path = "classpath:sql/" + folderName + "/" + fileName;
        Resource resource = resolver.getResource(path);
        if (!resource.exists()) {
            throw new IOException("No SQL files found in folder " + folderName + "/" + fileName);
        }
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, resource);
        }
    }
}
