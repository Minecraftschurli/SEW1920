package gburkl.util;

import java.util.function.Function;

/**
 * @author Georg Burkl
 * @version 2020-02-20
 */
public interface IMappable<T> {
    <U> IMappable<U> map(Function<? super T, ? extends U> mapper);
}
