package util;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 2016/12/11.
 */
public class AddTradProducerTest {

    @Test
    public void getAllAddress() throws Exception {
        Iterator<String> output = AddTradProducer.getAllAddress();
        while(output.hasNext()){
            System.out.print(output.next() + " ");
        }
    }

    @Test
    public void getTradingAreasByAddress() throws Exception {
        Iterator<String> output = AddTradProducer.getTradingAreasByAddress("");
        while(output.hasNext()){
            System.out.print(output.next() + " ");
        }
    }

}