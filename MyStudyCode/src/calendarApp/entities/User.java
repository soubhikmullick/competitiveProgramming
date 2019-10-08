package calendarApp.entities;

public class User {
    private int id;
    private Calendar calendar;

    private String response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override public String toString() {
        return String.format("User id : " + getId() + " calendar=" + calendar + " response='" + response + "\'" +"\n");
    }
}
