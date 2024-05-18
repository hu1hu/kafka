# 使用官方 Maven 镜像作为基础镜像
FROM maven:3.8.4-openjdk-17-slim AS build
# 设置工作目录
WORKDIR /app
# jar 文件
COPY target/kafka-0.0.1-SNAPSHOT.jar /app/kafka.jar
# 运行
CMD ["java", "-jar", "/app/kafka.jar"]