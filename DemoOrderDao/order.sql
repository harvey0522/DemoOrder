CREATE TABLE `tb_order` (
                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Key',
                         `order_no` bigint DEFAULT NULL COMMENT '订单号',
                         `goods_no` bigint DEFAULT NULL,
                         `price` decimal(10,2) DEFAULT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;