package bd.edu.seu.nazmul;

public class MySeries {
    private String name;
    private String season;
    private String year;
    private double rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public MySeries(String name, String season, String year, double rating) {
        this.name = name;
        this.season = season;
        this.year = year;
        this.rating = rating;
    }
}
