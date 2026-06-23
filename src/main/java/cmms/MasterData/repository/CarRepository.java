package cmms.MasterData.repository;

import cmms.MasterData.entity.CarModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarModule,Long>{



}
