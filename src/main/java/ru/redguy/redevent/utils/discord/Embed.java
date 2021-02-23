package ru.redguy.redevent.utils.discord;

import org.json.JSONArray;
import org.json.JSONObject;

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
        JSONObject result = new JSONObject();
        JSONArray embdeds = new JSONArray();
        JSONObject res = new JSONObject();

        if(title != null) {
            result.put("title",title);
        }
        if(description != null) {
            result.put("description",description);
        }
        if(fields != null) {
            JSONArray jsonArray = new JSONArray();
            for (Field field : fields) {
                jsonArray.put(field.toJsonObject());
            }
            result.put("fields",jsonArray);
        }

        embdeds.put(result);
        res.put("embeds",embdeds);
        return res.toString();
    }
}
