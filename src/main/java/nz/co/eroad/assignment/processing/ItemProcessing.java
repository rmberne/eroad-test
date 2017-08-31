package nz.co.eroad.assignment.processing;

/**
 * Main processing abstraction.
 * Data to be processed comes from {@link ItemReader}.
 * Data to be written comes from {@link ItemWriter}.
 * <p>
 * A simple process method should be overridden.
 *
 * @author Rafael Berne
 * @since 30/08/17.
 */
public abstract class ItemProcessing<I, O> {

    private ItemReader<I> reader;
    private ItemWriter<O> writer;

    protected ItemProcessing(ItemReader<I> reader, ItemWriter<O> writer) {
        this.reader = reader;
        this.writer = writer;
    }

    protected abstract O process(I item);

    public void run() {
        I item;
        while ((item = reader.read()) != null) {
            O result = process(item);

            if (result != null) {
                writer.write(result);
            }

        }
        writer.close();
    }

}
