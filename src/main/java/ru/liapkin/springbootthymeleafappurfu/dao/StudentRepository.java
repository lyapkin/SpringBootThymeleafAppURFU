package ru.liapkin.springbootthymeleafappurfu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liapkin.springbootthymeleafappurfu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
