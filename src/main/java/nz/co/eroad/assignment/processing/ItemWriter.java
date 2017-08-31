package nz.co.eroad.assignment.processing;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public interface ItemWriter<T> {

    void write(T item);

    void close();

}
