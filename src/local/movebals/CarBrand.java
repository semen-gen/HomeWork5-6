package local.movebals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public enum CarBrand {
    MERCEDES("Мерседес-бенц", "Mersedes-benz", "Germany", new int[]{28, Calendar.JUNE, 1926}),
    BMW("БМВ", "BMW", "Germany", new int[]{7, Calendar.MARCH, 1917}),
    MAZDA("Мазда", "Mazda", "Japan", new int[]{30, Calendar.JANUARY, 1920}),
    TESLA("Тесла", "Tesla", "USA", new int[]{1, Calendar.JULY, 2003}),
    LADA("Лада", "Lada", "USSR", new int[]{20, Calendar.JULY, 1966});

    private final String NAME_RU;
    private final String NAME_EN;
    private final String COUNTRY;
    private final Calendar FOUNDATION;

    CarBrand(String nameRu, String nameEn, String country, int[] foundation) {
        this.NAME_RU = nameRu;
        this.NAME_EN = nameEn;
        this.COUNTRY = country;
        this.FOUNDATION = new Calendar.Builder().setDate(foundation[2], foundation[1], foundation[0]).build();
    }

    public String getNameRu() {
        return NAME_RU;
    }

    public String getNameEn() {
        return NAME_EN;
    }

    public String getCountry() {
        return COUNTRY;
    }

    public String getFoundation() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy");
        return dateFormat.format(FOUNDATION.getTime());
    }
}
