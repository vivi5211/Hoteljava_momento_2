package application.domain;

public class Guest extends Person {

    private String origin;
    private String guestType;

    public Guest() {
        super();
    }

    public Guest(int id, String name, String lastName, String email, String password, Boolean state, String origin, String guestType) {
        super(id, name, lastName, email, password, state);
        this.origin = origin;
        this.guestType = guestType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "origin='" + origin + '\'' +
                ", guestType='" + guestType + '\'' +
                "} " + super.toString();
    }
}
