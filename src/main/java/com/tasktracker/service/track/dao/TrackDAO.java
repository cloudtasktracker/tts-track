package com.tasktracker.service.track.dao;

import com.tasktracker.service.track.conf.AppConf;
import com.tasktracker.service.track.entity.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * Created by joan on 24/7/15.
 */
public class TrackDAO {

    public void addTrack(Long taskId, String status){
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName(AppConf.dbConf.getProperty("db.driver"));
            c = DriverManager.getConnection(AppConf.dbConf.getProperty("db.url")+AppConf.dbConf.getProperty("db.schema"), AppConf.dbConf.getProperty("db.user"), AppConf.dbConf.getProperty("db.password"));
            c.setAutoCommit(false);

            stmt = c.prepareStatement(AppConf.dbConf.getProperty("sql.insert.created.task.track"));
            stmt.setLong(1, taskId);
            stmt.setString(2, status);

            stmt.executeUpdate();

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public void putTrack(Long taskId, Long userId, String status){
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName(AppConf.dbConf.getProperty("db.driver"));
            c = DriverManager.getConnection(AppConf.dbConf.getProperty("db.url")+AppConf.dbConf.getProperty("db.schema"), AppConf.dbConf.getProperty("db.user"), AppConf.dbConf.getProperty("db.password"));
            c.setAutoCommit(false);

            stmt = c.prepareStatement(AppConf.dbConf.getProperty("sql.insert.done.task.track"));
            stmt.setLong(1, taskId);
            stmt.setLong(2, userId);
            stmt.setString(3, status);

            stmt.executeUpdate();

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
