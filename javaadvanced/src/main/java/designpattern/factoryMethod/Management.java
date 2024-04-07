package designpattern.factoryMethod;

import designpattern.factoryMethod.creator.DataReaderFactory;
import designpattern.factoryMethod.product.DataReader;

public class Management {

    private DataReaderFactory dataReaderFactory;

    public Management(DataReaderFactory dataReaderFactory) {
        this.dataReaderFactory = dataReaderFactory;
    }

    public void process(){
        DataReader dataReader = dataReaderFactory.create();
        dataReader.getData();
    }


}
