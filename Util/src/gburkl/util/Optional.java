package gburkl.util;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Georg Burkl
 * @version 2020-02-20
 */
public class Optional<T> implements IOptional<T>, IMappable<T> {
    private final T value;

    private Optional(T value) {
        this.value = value;
    }

    public static <T> Optional<T> ofNullable(T value) {
        if (value == null)
            return IOptional.empty();
        else
            return new Optional<>(value);
    }
    @Override
    public <U> IMappable<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return IOptional.empty();
        } else {
            return ofNullable(mapper.apply(value));
        }
    }

    @Override
    public boolean isPresent() {
        return value != null;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        if (isPresent())
            consumer.accept(value);
    }

    @Override
    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R extends IOptional<T>> R filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return (R) this;
        } else {
            return predicate.test(value) ? (R) this : IOptional.empty();
        }
    }
}
