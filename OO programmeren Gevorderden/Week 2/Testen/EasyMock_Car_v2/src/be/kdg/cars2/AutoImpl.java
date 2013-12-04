package be.kdg.cars2;

public class AutoImpl implements Auto {
    private Motor motor;

    public AutoImpl() {
        // origineel: motor = new DieselMotor();
        motor = maakMotor();
    }

    // Toegevoegd om de klasse testbaar te maken (met anonymous inner class)
    protected Motor maakMotor() {
        return new DieselMotor();
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