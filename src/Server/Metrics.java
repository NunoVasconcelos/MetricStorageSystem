package Server;


import java.math.BigInteger;

public class Metrics {
    private BigInteger blockCount;
    private BigInteger instrCount;
    private BigInteger fieldLoad;
    private BigInteger fieldStore;
    private BigInteger load;
    private BigInteger store;
    public Metrics (BigInteger blockCount,BigInteger instrCount,BigInteger fieldLoad,BigInteger fieldStore, BigInteger load, BigInteger store)
    {
        this.blockCount = blockCount;
        this.instrCount = instrCount;
        this.fieldLoad = fieldLoad;
        this.fieldStore = fieldStore;
        this.load = load;
        this.store = store;
    }
}
