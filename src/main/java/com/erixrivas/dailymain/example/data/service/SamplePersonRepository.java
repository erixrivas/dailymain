package com.erixrivas.dailymain.example.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erixrivas.dailymain.example.data.entity.SamplePerson;

import java.time.LocalDate;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, Integer> {

}