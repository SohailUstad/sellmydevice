package in.sellmydevice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sellmydevice.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long>{

}
