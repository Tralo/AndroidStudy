package com.example;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class BeanGenerator {


    public static void main(String args[]) throws Exception {

	//生成策略: 传入参数为数据库版本号和生成代码的包路径
        Schema schema = new Schema(1,"com.example");
	//生成的数据据表
        addRecord(schema);
	//将自动生成的代码文件
        new DaoGenerator().generateAll(schema,"/home/taotao/project/AndroidStudy/greendaodemo/src/main/java-gen");
    }
    private static void addRecord(Schema schema){
	//生成一张数据表，名为"Record"
        Entity record = schema.addEntity("Record");
	//将自动生成的代码文件放到刚刚创建 java-gen目录  
	record.addIdProperty();
        record.addStringProperty("text").notNull();
        record.addDateProperty("date");


    }
}
