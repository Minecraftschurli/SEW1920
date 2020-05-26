package gburkl.util;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author Georg Burkl
 * @version 2020-02-20
 */
public class LazyValue<T> implements ILazy<T> {
    private Supplier<T> supplier;
    private T value;

    private LazyValue(Supplier<T> supplierIn) {
        this.supplier = supplierIn;
    }

    public static <T> LazyValue<T> of(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        if (supplier instanceof ILazy)
            return (LazyValue<T>) supplier;
        return new LazyValue<>(supplier);
    }

    @Override
    public T get() {
        Supplier<T> supplier = this.supplier;
        if (supplier != null) {
            this.value = supplier.get();
            this.supplier = null;
        }

        return this.value;
    }
}
