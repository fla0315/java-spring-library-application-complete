package com.group.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링이 실행될 때 자동으로 설정해주는 어플리케이션
public class LibraryAppApplication {

  public static void main(String[] args) {

    SpringApplication.run(LibraryAppApplication.class, args); //스프링 어플리케이션을 실행한다

  }
}
