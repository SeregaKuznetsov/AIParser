package ru.kpfu.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Calculator;

import java.sql.Time;
import java.util.List;

@Repository
public interface MathOperationRepository extends JpaRepository<Calculator, Long> {

   List<Calculator> findByDateGreaterThan(Time date);

}
