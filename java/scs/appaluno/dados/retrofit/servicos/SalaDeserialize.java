package scs.appaluno.dados.retrofit.servicos;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import scs.appaluno.modelo.Sala;

/**
 * Created by joaoc_000 on 21/05/2018.
 */

public class SalaDeserialize implements JsonDeserializer
{
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement elemento = json.getAsJsonObject();

        if(json.getAsJsonObject() != null)
        {
            elemento = json.getAsJsonObject();
        }

        return (new Gson().fromJson(elemento, Sala.class));
    }
}