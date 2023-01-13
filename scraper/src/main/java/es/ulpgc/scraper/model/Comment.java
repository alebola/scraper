package es.ulpgc.scraper.model;

public class Comment {

    public String comment;
    public String commentrating;
    public String commentdate;

    public Comment(String comment, String commentrating, String commentdate) {
        this.comment = comment;
        this.commentrating = commentrating;
        this.commentdate = commentdate;
    }


    public String getComment() {
        return comment;
    }

    public String getCommentrating() {
        return commentrating;
    }

    public String getCommentdate() {
        return commentdate;
    }
}
