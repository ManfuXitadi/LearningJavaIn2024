package designpattern.factoryMethod;

import designpattern.factoryMethod.creator.*;
import designpattern.factoryMethod.product.DataReader;

public class Main {


    public static void main(String[] args) {
        DataReaderFactory dataReaderFactory = new FileDataReaderFactory();
        Management dataReader = new Management(dataReaderFactory);
        dataReader.process();
    }
}
