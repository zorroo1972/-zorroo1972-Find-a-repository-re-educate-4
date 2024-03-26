package ru.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;
@Component
public class BuilderDB implements Consumer<ModelTitle> {
    Connection con;
    Statement statement;
    @Autowired DBConfig dbConfig;
    @Override
    public void accept(ModelTitle modelTitle) {
        try {
            con = dbConfig.dataSource().getConnection();
            statement = con.createStatement();
            String queryStr = "drop table if exists " + modelTitle.name;
            statement.executeUpdate(queryStr);
            queryStr = "create table if not exists " + modelTitle.name+"(\n" +
                    "id bigserial not null,\n";
            String[] words = modelTitle.source.split(";");
            for (String word : words) {
                queryStr = queryStr + word + " varchar not null,\n";
            }
            queryStr = queryStr + "primary key (id))";
            statement.executeUpdate(queryStr);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
