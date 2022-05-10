package ru.yandex.practicum.filmorate.validators;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.exceptions.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

@Slf4j
public class FilmValidator {

    public boolean validator(Film film) {

        nameValidator(film.getName());

        descriptionValidator(film.getDescription());

        releaseDateValidator(film.getReleaseDate());

        durationValidator(film.getDuration());

        return true;

    }

    private boolean nameValidator(String name) {

        if (name.isEmpty()) {
            log.info("название фильма пустое.");
            throw new ValidationException("Название фильма не может быть пустым.");
        }

        return true;

    }

    private boolean descriptionValidator(String description) {

        if (description.length() > 200) {
            log.info("Описание фильма больше 200-т символов");
            throw new ValidationException("Описание не может быть больше 200 символов");
        }

        if (description.isEmpty()) {
            log.info("Описание фильма пустое");
            throw new ValidationException("Описание не может быть пустым.");
        }

        return true;

    }

    private boolean releaseDateValidator(LocalDate releaseDate) {

        if (releaseDate.isBefore(LocalDate.of(1895, 12, 28))) {
            log.info("Дата релиза ранее 28 декабря 1895 года.");
            throw new ValidationException("Дата релиза не может быть раньше 28 декабря 1895 года.");
        }

        return true;

    }

    private boolean durationValidator(int duration) {

        if (duration <= 0) {
            log.info("Продолжительность фильма не положительная.");
            throw new ValidationException("Продолжительность фильма должна быть положительной.");
        }

        return true;

    }

}
