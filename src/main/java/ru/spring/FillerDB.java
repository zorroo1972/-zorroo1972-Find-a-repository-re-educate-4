package ru.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;
@LogTransformation
@Component
public class FillerDB implements Consumer<ModelBody>  {
    Connection con;
    Statement statement;
    @Autowired DBConfig dbConfig;
    @Override
    public void accept(ModelBody modelBody) {
        try {
            con = dbConfig.dataSource().getConnection();
            statement = con.createStatement();
            String queryStr = "INSERT INTO " +modelBody.name+" VALUES("+modelBody.id;
            String[] words = modelBody.source.split(";");
            for (String word : words) {
                queryStr = queryStr +",\'"+ word+"\'";
            }
            queryStr = queryStr + ")";
            statement.executeUpdate(queryStr);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


