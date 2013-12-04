package be.kdg.mock;

public class MockMotor implements Motor {
    private int toerental;
    private int temperatuur;

    public void setToerental(int toerental) {
        this.toerental = toerental;
    }

    public int getToerental() {
        return toerental;
    }

    public void setTemperatuur(int temperatuur) {
        this.temperatuur = temperatuur;
    }

    public int getTemperatuur() {
        return temperatuur;
    }

}
