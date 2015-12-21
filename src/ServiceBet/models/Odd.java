package ServiceBet.models;

public class Odd {

    private float odd1;
    private float oddx;
    private float odd2;

    public Odd(float odd1, float oddx, float odd2) {
        this.odd1 = odd1;
        this.oddx = oddx;
        this.odd2 = odd2;
    }

    public Odd() {
        this.odd1 = 0;
        this.oddx = 0;
        this.odd2 = 0;
    }

    public float getOdd1() {
        return this.odd1;
    }

    public void setOdd1(float odd1) {
        this.odd1 = odd1;
    }

    public float getOddx() {
        return this.oddx;
    }

    public void setOddx(float oddx) {
        this.oddx = oddx;
    }

    public float getOdd2() {
        return this.odd2;
    }

    public void setOdd2(float odd2) {
        this.odd2 = odd2;
    }

    public void actualiza(float odd1, float oddx, float odd2) {
        this.setOddx(oddx);
        this.setOdd1(odd1);
        this.setOdd2(odd2);
    }

    @Override
    public Odd clone() {
        Odd newOdd = new Odd();
        newOdd.setOdd1(this.odd1);
        newOdd.setOdd2(this.odd2);
        newOdd.setOddx(this.oddx);
        return newOdd;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Odd1 - ").append(odd1).append("\n");
        s.append("Oddx - ").append(oddx).append("\n");
        s.append("Odd2 - ").append(odd2).append("\n");
        return s.toString();
    }

}
