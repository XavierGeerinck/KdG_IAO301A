package be.kdg.car;

public class AutoImpl implements Auto {
    private Motor motor;

    public AutoImpl(Motor motor) {
        this.motor = motor;
    }

    public void versnel(int toename) {
        int toerental = motor.getToerental();
        toerental += toename;
        motor.setToerental(toerental);
    }

    public void vertraag(int afname) {
        int toerental = motor.getToerental();
        toerental -= afname;
        toerental = Math.max(toerental, 0);
        motor.setToerental(toerental);
    }

    public int getSnelheid() {
        return (motor.getToerental() / 10);
    }

    public String getStatus() {
        int temp = motor.getTemperatuur();
        if (temp > MAX_OLIETEMPERATUUR) {
            return "oververhitting";
        } else {
            return "ok";
        }
    }
}