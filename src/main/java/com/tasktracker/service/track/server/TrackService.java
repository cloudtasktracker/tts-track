package com.tasktracker.service.track.server;

import com.tasktracker.libraries.common.entity.TaskStatus;
import com.tasktracker.libraries.common.logging.LoggingCodes;
import com.tasktracker.libraries.common.logging.OperationLogger;
import com.tasktracker.service.track.dao.TrackDAO;

import javax.ws.rs.*;

/**
 *
 * Created by joan on 4/7/15.
 */
@Path("/service/track")
public class TrackService {

    private TrackDAO trackDAO;
    
    public TrackService(){
        this.trackDAO = new TrackDAO();
    }

    @POST
    @Path("/add/{taskId}")
    @Produces("application/json")
    public String addTrack(@PathParam("taskId") String taskId, @PathParam("userId") String userId, @PathParam("status") String status) {
        OperationLogger operationLogger = new OperationLogger(LoggingCodes.TTS_TRACK_ADD.getCode(),false);
        this.trackDAO.addTrack(Long.valueOf(taskId), TaskStatus.CREATED.getStatus());
        operationLogger.operationFinished();
        return "Track added: "+taskId;
    }

    @POST
    @Path("/put/{taskId}/{userId}/{status}")
    @Produces("application/json")
    public String updateTrack(@PathParam("taskId") String taskId, @PathParam("userId") String userId, @PathParam("status") String status) {
        OperationLogger operationLogger = new OperationLogger(LoggingCodes.TTS_TRACK_ADD.getCode(),false);
        this.trackDAO.putTrack(Long.valueOf(taskId), Long.valueOf(userId), status);
        operationLogger.operationFinished();
        return "Track putted: "+taskId;
    }

}
