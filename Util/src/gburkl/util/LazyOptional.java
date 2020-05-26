package gburkl.util;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Georg Burkl
 * @version 2020-02-20
 */
public class LazyOptional<T> implements IOptional<T>, ILazy<T>, IMappable<T> {
    private final Supplier<T> supplier;
    private T value;
    private boolean cached = false;

    private LazyOptional(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> LazyOptional<T> of(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        if (supplier instanceof ILazy)
            return (LazyOptional<T>) supplier;
        return new LazyOptional<>(supplier);
    }

    @Override
    public <U> IMappable<U> map(Function<? super T, ? extends U> mapper) {
        return isPresent() ? new LazyOptional<>(() -> mapper.apply(value)) : (IMappable<U>) this;
    }

    @Override
    public boolean isPresent() {
        return cached && value != null;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        if (this.isPresent()) consumer.accept(this.get());
    }

    @Override
    public T get() {
        if (!this.cached) {
            this.value = supplier.get();
            this.cached = true;
        }
        return this.value;
    }
}
