## 테이블 스키마


##### team table
```
CREATE TABLE `team` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `manager` varchar(100) NULL,
  `member_count` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`)
)
```

##### employee table
```
CREATE TABLE `employee` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `team_name` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `work_start_date` date NOT NULL,
  PRIMARY KEY (`id`)
)
```