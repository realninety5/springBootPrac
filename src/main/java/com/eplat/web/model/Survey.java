package com.eplat.web.model;

import java.util.List;

public class Survey {
    private List<Question> questions;
    private String title;
    private String desc;
    private String id;

    public Survey(String id, String title, String desc, List<Question> questions) {
        super();
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.questions = questions;
    }

    public String getId() { return this.id; }
    public void setId(String id){ this.id = id; }
    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }
    public String getDesc(String desc) { return this.desc; }
    public void setDesc(String desc) { this.desc = desc; }
    public List<Question> getQuestions() { return this.questions; }
    public void setQuestions(List<Question> questions) { this.questions = questions; }

    @Override
    public String toString() {
        return "Survey [id=" + id + ", title=" + title + ", description="
                + desc + ", questions=" + questions + "]";
    }
}
