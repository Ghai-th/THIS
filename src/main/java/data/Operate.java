package data;

public class Operate implements java.io.Serializable{
    public int operate;

    public Operate(int operate) {
        this.operate = operate;
    }

    public Operate() {

    }

    public int getOperate() {
        return operate;
    }

    public void setOperate(int operate) {
        this.operate = operate;
    }
}
