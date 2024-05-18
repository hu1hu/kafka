package org.example.kafka.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * 测试
 */

@RestController
@Slf4j
public class TestController {

    /**
     * 接口测试
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @Autowired
    private KafkaTemplate<Object, Object> template;

//    @PostMapping("/producer")
//    public String producer(@RequestParam String topic, @RequestParam String message) {
//        template.send(topic, message);
//        return "success";
//    }

//    @KafkaListener(concurrency = "3", topics = "test")
//    public void processMessage(List<ConsumerRecord<String,String>> records, Acknowledgment ack) {
//        System.out.println(records);
//        for (ConsumerRecord<String, String> record : records) {
//            System.out.println(record.value());
//        }
//        // 手动提交offset，里面的逻辑是采用的同步提交，尝试3次
//        ack.acknowledge();
//    }
}
