package org.example.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyCountRepository extends JpaRepository<FrequencyCount,Integer> {
     FrequencyCount findByQuery(String query);
}
