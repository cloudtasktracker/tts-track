package com.tasktracker.service.track.starter;

import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import com.tasktracker.service.track.conf.AppConf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TrackServiceStarter {

    final static Logger logger = Logger.getLogger("Starter");

    public static void main(String[] args) throws IOException {
        new AppConf();
        final String port = System.getenv("TTS_TRACK_CONF").equals("wc")?System.getenv("TTS_TRACK_PORT"):System.getenv("PORT");
        final String baseUri = "http://localhost:"+port+"/";
        final Map<String, String> initParams = new HashMap<>();
        initParams.put("com.sun.jersey.config.property.packages", "com.tasktracker.service.track.server");
        logger.info("----------- TTS-TRACK: Grizzly Server starter at: "+baseUri);
        GrizzlyWebContainerFactory.create(baseUri, initParams);
    }
}
