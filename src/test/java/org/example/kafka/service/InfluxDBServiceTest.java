package org.example.kafka.service;

import com.influxdb.client.InfluxDBClient;
import org.example.kafka.service.impl.InfluxDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//public class InfluxDBServiceTest {
//    @Autowired
//    private InfluxDBService influxDBService;
//
//    @Test
//    void writeData() {
//        //数据格式 <measurement>[,<tag-key>=<tag-value>...] <field-key>=<field-value>[,<field2-key>=<field2-value>...] [unix-nano-timestamp]
//        influxDBService.writeDataByString("mem,host=host1 used_percent=25");
//    }
//}
