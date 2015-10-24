package com.tasktracker.service.track;

import com.tasktracker.service.track.conf.AppConf;
import com.tasktracker.service.track.dao.TrackDAO;
import com.tasktracker.service.track.entity.Track;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * Created by joan on 24/7/15.
 */
public class TrackDAOTest {

    private TrackDAO trackDAO;
    private Long taskId;

    @Before
    public void setUp(){
        new AppConf();
        this.trackDAO = new TrackDAO();
        this.taskId = 2l;
    }

    @After
    public void tearDown(){
        this.trackDAO = null;
        this.taskId = null;
    }

}
