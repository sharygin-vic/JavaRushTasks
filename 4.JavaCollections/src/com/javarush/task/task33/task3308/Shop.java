package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 07-Jun-17.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop {

    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    @Override
    public String toString() {
        StringBuilder goodsStrB = new StringBuilder("{");
        if (goods != null && goods.names != null) {
            for (String s : goods.names) {
                goodsStrB.append(s).append("; ");
            }
        }
        goodsStrB.append("}");
        return "Shop{" +
                "goods=" + goodsStrB.toString() +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + Arrays.toString(secretData) +
                '}';
    }

    @XmlType(name = "goods")
    public static class Goods {
        public List<String> names;
    }
}
