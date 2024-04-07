package designpattern.factoryMethod.creator;

import designpattern.factoryMethod.product.DBDataReader;
import designpattern.factoryMethod.product.DataReader;

public class DBDataReaderFactory implements DataReaderFactory{
    public DataReader create() {
        return new DBDataReader();
    }
}
