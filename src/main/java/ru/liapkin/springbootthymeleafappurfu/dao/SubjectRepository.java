package ru.liapkin.springbootthymeleafappurfu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liapkin.springbootthymeleafappurfu.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
