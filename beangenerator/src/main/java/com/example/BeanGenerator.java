package com.example;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class BeanGenerator {


    public static void main(String args[]) throws Exception {

        Schema schema = new Schema(1,"com.example");
        addRecord(schema);
        new DaoGenerator().generateAll(schema,"/home/taotao/project/AndroidStudy/greendaodemo/src/main/java-gen");
    }
    private static void addRecord(Schema schema){
        Entity record = schema.addEntity("Record");
        record.addIdProperty();
        record.addStringProperty("text").notNull();
        record.addDateProperty("date");


    }
}
