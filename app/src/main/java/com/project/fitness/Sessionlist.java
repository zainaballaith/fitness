package com.project.fitness;

public class Sessionlist {

    private String sname,trainer_user,start_date,end_date,start_time,end_time,pic;

    public Sessionlist(String sname, String trainer_user, String start_date , String end_date,String start_time,String end_time,String pic)
    {

        this.sname = sname;
        this.trainer_user = trainer_user ;
        this.start_date =start_date;
        this.end_date = end_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.pic = pic;


    }

    public String getSname() {
        return sname;
    }

    public String getTrainer_user() {
        return trainer_user;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getPic() {
        return pic;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setTrainer_user(String trainer_user) {
        this.trainer_user = trainer_user;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
