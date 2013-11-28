package Model;

import java.sql.*;

public class Appointment {

    private int appointmentId, patientID;
    private String appointmentDateTime, appointmentDescription;
    private Connection connection;

    // get existing patient
    public Appointment(Connection connection) {
        this.connection = connection;
    }

    public void setAppointmentDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    // get from database
    public void get(int appointmentId) {
        PreparedStatement statement = null;
        try {
            String query = "select * from appointments where appointmentId = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, appointmentId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            // map database values to object
            setPatientId(resultSet.getInt("appointmentId"));
            setAppointmentDateTime(resultSet.getString("appointmentDateTime"));
            setAppointmentDescription(resultSet.getString("appointmentDescription"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // insert into database
    public void create(int appointmentId, String appointmentDateTime, String description) {
        this.appointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.appointmentDescription = description;
        this.insert();
    }

    // update existing patient into database
    public void update() {
        if (getAppointmentId() == -1) {
            throw new IllegalArgumentException("Trying to update with no appointmentId.");
        }
        try {
            PreparedStatement statement = null;
            String sql = "update appointments " +
                    "set appointmentDateTime = ?, appointmentDescription = ? " +
                    "where appointmentId = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, getAppointmentDateTime());
            statement.setString(2, getAppointmentDescription());
            statement.setInt(3, getAppointmentId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert() {
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO appointments" +
                    "([patientId],[appointmentDateTime],[appointmentDescription])" +
                    "VALUES(?,?,?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, getPatientId());
            statement.setString(2, getAppointmentDateTime());
            statement.setString(3, getAppointmentDescription());
            statement.execute();
            // get identity value
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                appointmentId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete() {

    }

    public int getPatientId() {
        return patientID;
    }

    // don't allow outside access to patientId
    private void setPatientId(int patientID) {
        this.patientID = patientID;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }
}