package ru.redguy.redevent.utils.discord;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Embed {

    private String title = null;
    private String description = null;
    private List<Field> fields = null;

    public Embed() {

    }

    public Embed setTitle(String title) {
        this.title = title;
        return this;
    }

    public Embed setDescription(String description) {
        this.description = description;
        return this;
    }

    public Embed appendField(Field field) {
        if(fields == null) {
            fields = new ArrayList<>();
        }
        fields.add(field);
        return this;
    }

    public String toJson() {
        JsonObject result = new JsonObject();
        JsonArray embdeds = new JsonArray();
        JsonObject res = new JsonObject();

        if(title != null) {
            result.addProperty("title",title);
        }
        if(description != null) {
            result.addProperty("description",description);
        }
        if(fields != null) {
            JsonArray jsonArray = new JsonArray();
            for (Field field : fields) {
                jsonArray.add(field.toJsonObject());
            }
            result.add("fields",jsonArray);
        }

        embdeds.add(result);
        res.add("embeds",embdeds);
        return res.toString();
    }
}
