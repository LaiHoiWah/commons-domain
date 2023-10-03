package com.meowu.commons.doamin.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class GsonUtils{

    private final static Gson DEFAULT_GSON = getGson(false, false, true);

    private GsonUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static Gson getGson(boolean serializeNulls, boolean escapeHtmlChars, boolean toTimestamp){
        GsonBuilder builder = new GsonBuilder();

        // config setting
        if(serializeNulls){
            builder.serializeNulls();
        }
        if(!escapeHtmlChars){
            builder.disableHtmlEscaping();
        }
        if(toTimestamp){
            builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));
            builder.registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, typeOfT, context) -> new JsonPrimitive(date.getTime()));
        }

        return builder.create();
    }

    public static String toJson(Object src){
        return DEFAULT_GSON.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOf){
        if(classOf == null){
           throw new IllegalArgumentException("Class must not be null");
        }

        return DEFAULT_GSON.fromJson(json, classOf);
    }

    public static <T> T fromJson(String json, Type typeOf){
        if(typeOf == null){
            throw new IllegalArgumentException("Type must not be null");
        }

        return DEFAULT_GSON.fromJson(json, typeOf);
    }
}
