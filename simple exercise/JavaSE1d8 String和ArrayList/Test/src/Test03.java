public class Test03 {
    private String name;
    private String yanyuan;
    private int year;
    private double score;

    public Test03() {
    }

    public Test03(String name, String yanyuan, int year, double score) {
        this.name = name;
        this.yanyuan = yanyuan;
        this.year = year;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYanyuan() {
        return yanyuan;
    }

    public void setYanyuan(String yanyuan) {
        this.yanyuan = yanyuan;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Test03{" +
                "name='" + name + '\'' +
                ", yanyuan='" + yanyuan + '\'' +
                ", year=" + year +
                ", score=" + score +
                '}';
    }
}
