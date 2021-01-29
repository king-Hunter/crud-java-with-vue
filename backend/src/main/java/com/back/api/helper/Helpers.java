package com.back.api.helper;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Helpers implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -247898121454918732L;

    public static ZonedDateTime obtenerFechaActual() {
        final Instant instant = Instant.now();
        return instant.atZone(ZoneId.of("UTC"));
    }

}