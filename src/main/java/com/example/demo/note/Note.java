package com.example.demo.note;

public class Note {
    private Long id;
    private String title;
    private String content;


    public Note() {
        this.title = "";
        this.content = "";
        this.id = null;
    }



    public Long getId() {
        return (long) Math.toIntExact(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Note note = (Note) obj;
        return id != null && id.equals(note.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }
}
