public enum Season {
    WINTER(-15),
    SPRING(12),
    SUMMER(27),
    AUTUMN(7);

    private final int averageTemp;

    Season(int averageTemp) {
        this.averageTemp = averageTemp;
    }

    public int getAverageTemp() {
        return averageTemp;
    }

    public String getDescription() {
        switch (this) {
            case SUMMER:
                return "Теплое время года";
            default:
                return "Холодное время года";
        }
    }
}
