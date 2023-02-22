package com.meawallet.parkingapp.database;
import com.meawallet.parkingapp.database.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.database.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.domain.ParkingLot;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor

public class ParkingLotHibernateRepository implements ParkingLotRepository{
    private final SessionFactory sessionFactory;
    private final ParkingLotDomainToParkingLotEntity converterDomainToEntity;
    private final ParkingLotEntityToParkingLotDomain converterEntityToDomain;

    @Override
    public ParkingLotEntity save (ParkingLot parkingLot) {
        var entity = converterDomainToEntity.convert(parkingLot, null);
        sessionFactory.getCurrentSession().persist(entity);
        return entity;
    }
    @Override
    public Optional<ParkingLot> getParkingLotById(Integer id) {
        var entity = sessionFactory.getCurrentSession().find(ParkingLotEntity.class, id);
        return Optional.ofNullable(entity)
                .map(converterEntityToDomain::convert);
    }
    @Override
    public ParkingLotEntity update(ParkingLot parkingLot) {
        var entity = converterDomainToEntity.convert(parkingLot, parkingLot.getId());
        sessionFactory.getCurrentSession().merge(entity);
        return entity;
    }

    @Override
    public void delete(ParkingLot parkingLot) {
        var entity= converterDomainToEntity.convert(parkingLot, parkingLot.getId());
        sessionFactory.getCurrentSession().remove(entity);
    }

    @Override
   // @SuppressWarnings("unchecked")
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

    }
}
