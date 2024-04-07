package designpattern.factoryMethod.creator;

import designpattern.factoryMethod.product.DataReader;
import designpattern.factoryMethod.product.FileDataReader;

public class FileDataReaderFactory implements DataReaderFactory{
    public DataReader create() {
        return new FileDataReader();
    }
}
