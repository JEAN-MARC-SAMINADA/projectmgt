package com.bnpparibas.ism.projectmgt.infrastructure.processmgt;

public class ArtifactDTO {
    String tag;
    String name;
    boolean done=false;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
