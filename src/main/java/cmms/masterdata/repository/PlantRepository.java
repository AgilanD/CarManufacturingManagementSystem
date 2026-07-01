package cmms.masterdata.repository;

import cmms.masterdata.entity.Plants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plants,Long> {


}
