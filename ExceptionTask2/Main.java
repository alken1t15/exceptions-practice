package ExceptionTask2;

public class Main {
    public static void main(String[] args) {
        for (Event event : getMovies()) {
            validEvent(event);
        }
        for (Event event : getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события корректны");
    }

    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Начало", 2010, 16),
                new Movie("Обстрел", 2015, 18),
                new Movie("Форрест Гамп", 1994, 18),
                new Movie("Матрица", 1999, 16),
                new Movie("Бойцовский клуб", 1999, 18),
                new Movie("", 0, 756765),
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Анна Каренина", 2017, 16),
                new Theatre("Василий Иванович", 2018, 6),
                new Theatre("Иван Сусанин", 2004, 6),
                new Theatre("Лебединое озеро", 2000, 18),
                new Theatre("Призрак Оперы", 1995, 18),
                // new Theatre("", 43, 43),
        };
    }

    public static void validEvent(Event event) throws RuntimeException {
        if (event.getAge() == 0 | event.getReleaseYear() == 0 | event.getTitle().isEmpty()) {
            throw new RuntimeException();
        }
    }

}