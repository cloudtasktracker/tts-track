package com.tasktracker.service.track.entity;

import com.tasktracker.libraries.common.entity.TaskStatus;

import java.util.Date;

/**
 *
 * Created by joan on 24/7/15.
 */
public class Track {
    private Long id;
    private Long taskId;
    private String mail;
    private TaskStatus status;
    private Date date;

    public Track(Long id, Long taskId, String mail, TaskStatus status, Date date) {
        this.id = id;
        this.taskId = taskId;
        this.mail = mail;
        this.status = status;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getMail() {
        return mail;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }
}
