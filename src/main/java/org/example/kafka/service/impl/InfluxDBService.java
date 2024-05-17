package org.example.kafka.service.impl;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.example.kafka.config.InfluxDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class InfluxDBService {

    @Autowired
    private InfluxDBConfig influxDBConfig;

    // 客户端连接
    private InfluxDBClient client;

    public InfluxDBClient getClient() {
        if (client == null) {
            client = InfluxDBClientFactory.create(influxDBConfig.getUrl(), influxDBConfig.getToken().toCharArray());
        }
        return client;
    }

    public void writeDataByString(String data) {
        client = getClient();
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writeRecord(influxDBConfig.getBucket(), influxDBConfig.getOrg(), WritePrecision.NS, data);
    }

    public void writeDataByPoint(String measurement, Map<String, String> tagMap, Map<String, String> fieldMap) {
        Point point = Point.measurement(measurement);
        tagMap.forEach(point::addTag);
        fieldMap.forEach(point::addField);
        point.time(Instant.now(), WritePrecision.NS);
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writePoint(influxDBConfig.getBucket(), influxDBConfig.getOrg(), point);
    }

    public void writeDataByPOJO(Object pojo) {

    }
}
