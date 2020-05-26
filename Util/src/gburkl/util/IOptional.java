package gburkl.util;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Georg Burkl
 * @version 2020-02-20
 */
public interface IOptional<T> {
    IOptional<?> EMPTY = new IOptional<>() {
        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public void ifPresent(Consumer<? super Object> consumer) {

        }

        @Override
        public Object get() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public <R extends IOptional<Object>> R filter(Predicate<? super Object> predicate) {
            return null;
        }
    };

    @SuppressWarnings("unchecked")
    static <U, R extends IOptional<U>> R empty() {
        return (R) EMPTY;
    }

    boolean isPresent();

    void ifPresent(Consumer<? super T> consumer);

    T get();

    default boolean isEmpty() {
        return false;
    }

    default <R extends IOptional<T>> R filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (isPresent()) return predicate.test(get()) ? (R) this : empty();
        else return (R) this;
    }

    default Stream<T> stream() {
        if (isPresent()) return Stream.of(get());
        else return Stream.empty();
    }

    default T orElse(T other) {
        if (isPresent()) return get();
        return other;
    }

    default T orElseGet(Supplier<? extends T> supplier) {
        if (isPresent()) return get();
        return supplier.get();
    }

    default <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isPresent()) return get();
        else throw exceptionSupplier.get();
    }
}
