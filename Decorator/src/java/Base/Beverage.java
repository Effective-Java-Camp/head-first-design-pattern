package Base;
public abstract class Beverage {
    private String description;

    public String getDescription() {
        description = "Beverage : ";
        return description;
    }

    public Integer cost() {
        return 0;
    }
}