package ru.redguy.reduhc.utils.discord;

import com.google.gson.JsonObject;

public class Field {

    private String name = null;
    private String value = null;
    private boolean inline = true;

    public Field() {

    }

    public Field setName(String name) {
        this.name = name;
        return this;
    }

    public Field setValue(String value) {
        this.value = value;
        return this;
    }

    public Field setInline(boolean inline) {
        this.inline = inline;
        return this;
    }

    public JsonObject toJsonObject() {
        JsonObject result = new JsonObject();

        if(name != null) {
            result.addProperty("name",name);
        }
        if(value != null) {
            result.addProperty("value",value);
        }
        result.addProperty("inline",inline);

        return result;
    }
}
