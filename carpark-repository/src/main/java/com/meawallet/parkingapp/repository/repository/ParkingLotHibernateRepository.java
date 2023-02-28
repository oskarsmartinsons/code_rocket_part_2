package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.repository.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@AllArgsConstructor
public class ParkingLotHibernateRepository implements ParkingLotRepository{
    private final SessionFactory sessionFactory;
    private final ParkingLotDomainToParkingLotEntity converterDomainToEntity;
    private final ParkingLotEntityToParkingLotDomain converterEntityToDomain;

    @Override
    public ParkingLotEntity save(ParkingLot parkingLot) {
        var parkingLotEntity = converterDomainToEntity.convert(parkingLot);
        sessionFactory.getCurrentSession().persist(parkingLotEntity);
        return parkingLotEntity;
    }
  @Override
    public Optional<ParkingLot> getParkingLotById(Integer id) {
        var entity = sessionFactory.getCurrentSession().find(ParkingLotEntity.class, id);
        return Optional.ofNullable(entity)
                .map(converterEntityToDomain::convert);
    }
    @Override
    public ParkingLotEntity update(ParkingLot parkingLot) {
        var parkingLotEntity = converterDomainToEntity.convert(parkingLot);
        parkingLotEntity.setId(parkingLot.getId());
        sessionFactory.getCurrentSession().merge(parkingLotEntity);
        return parkingLotEntity;
    }

    @Override
    public void delete(ParkingLot parkingLot) {
        var parkingLotEntity = converterDomainToEntity.convert(parkingLot);
        parkingLotEntity.setId(parkingLot.getId());
        sessionFactory.getCurrentSession().remove(parkingLotEntity);
    }

/*    @Override
    public List<ParkingLot> getAllParkingLots() {
            var session = sessionFactory.getCurrentSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ParkingLotEntity> criteria = builder.createQuery(ParkingLotEntity.class);
            criteria.from(ParkingLotEntity.class);

            List<ParkingLotEntity> data = session.createQuery(criteria).getResultList();
            return data.stream()
                    .map(converterEntityToDomain::convert)
                    .collect(Collectors.toList());
    }

    @Override
    public void saveWithSlots(ParkingLot parkingLot) {

    }*/
}
