package org.sotux.strutsmvc.model.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class MenuOption {

    private String id;
    private String action;
    private String key;

    public MenuOption (String action, String key){
        this.action = action;
        this.key = key;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this, obj);
    }
    
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
