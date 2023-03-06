/*
package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.converter.ParkingSlotDomainToParkingSlotEntity;
import com.meawallet.parkingapp.repository.converter.ParkingSlotEntityToParkingSlotDomain;
import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class ParkingSlotHibernateRepository implements ParkingSlotRepository{
    private final SessionFactory sessionFactory;
    private final ParkingSlotDomainToParkingSlotEntity converterSlotDomainToEntity;
    private final ParkingSlotEntityToParkingSlotDomain converterSlotEntityToDomain;

    @Override
    public ParkingSlot save(ParkingSlot parkingSlot) {
        var parkingSlotEntity = converterSlotDomainToEntity.convert(parkingSlot);
        sessionFactory.getCurrentSession().persist(parkingSlotEntity);
        return converterSlotEntityToDomain.convert(parkingSlotEntity);
    }

    @Override
    public Optional<ParkingSlot> getParkingSlotById(Integer id) {
        var entity = sessionFactory.getCurrentSession().find(ParkingSlotEntity.class, id);
        return Optional.ofNullable(entity)
                .map(converterSlotEntityToDomain::convert);
    }

    @Override
    public ParkingSlot update(ParkingSlot parkingSlot) {
        var parkingSlotEntity = converterSlotDomainToEntity.convert(parkingSlot);
        parkingSlotEntity.setId(parkingSlot.getId());
        sessionFactory.getCurrentSession().merge(parkingSlotEntity);
        return converterSlotEntityToDomain.convert(parkingSlotEntity);
    }

    @Override
    public void delete(ParkingSlot parkingSlot) {
        var parkingSlotEntity = converterSlotDomainToEntity.convert(parkingSlot);
        parkingSlotEntity.setId(parkingSlot.getId());
        sessionFactory.getCurrentSession().remove(parkingSlotEntity);
    }

*/
/*    public List<ParkingSlot> getAllParkingSlotsByParkingLotId(Integer parkingLotId) {
        return repository.values().stream()
                .filter(entity->entity.getParkingLotId().equals(parkingLotId))
                .map(converterSlotEntityToDomain::convert)
                .collect(Collectors.toList());
    }*//*

}
*/
