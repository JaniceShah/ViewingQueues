package viewers_info;

import java.util.Date;

public class ViewingRequest {
    private Date dateApplied;
    private String name;
    private String address;
    private int income;
    private Date moveInDate;

    public ViewingRequest(Date dateApplied, String name, String address, int income, Date moveInDate) {
        this.dateApplied = dateApplied;
        this.name = name;
        this.address = address;
        this.income = income;
        this.moveInDate = moveInDate;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public int getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Date of Application: " + dateApplied;
    }
}
