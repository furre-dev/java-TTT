public class Player {
    private final String name;
    private String mark;

    public Player(String name, String mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

}
