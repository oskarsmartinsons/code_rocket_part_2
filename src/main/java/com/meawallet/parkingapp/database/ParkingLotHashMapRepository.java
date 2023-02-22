package com.meawallet.parkingapp.database;



import com.meawallet.parkingapp.database.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.database.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.domain.ParkingSlot;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
public class ParkingLotHashMapRepository implements ParkingLotRepository{
    private static Integer idSequence = 1;
    private final HashMap<Integer, ParkingLotEntity> repository;
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingLotDomainToParkingLotEntity converterDomainToEntity;
    private final ParkingLotEntityToParkingLotDomain converterEntityToDomain;

    @Override
    public ParkingLotEntity save (ParkingLot parkingLot) {
        ParkingLotEntity entity = converterDomainToEntity.convert(parkingLot, idSequence);
        idSequence++;
        repository.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<ParkingLot> getParkingLotById(Integer id) {
        return Optional.ofNullable(
                        repository.get(id))
                .map(converterEntityToDomain::convert);
    }
    @Override
    public ParkingLotEntity update(ParkingLot parkingLot) {
        return null;
    }

    @Override
    public void delete(ParkingLot parkingLot) {

    }
    @Override
    public List<ParkingLot> getAllParkingLots() {
        return repository.values().stream()
                .map(converterEntityToDomain::convert)
                .collect(Collectors.toList());
    }
    @Override
    public void saveWithSlots(ParkingLot parkingLot) {
        var entityLot = save(parkingLot);

        for (int i = 0; i < parkingLot.getSlotCount(); i++) {
            var slot = ParkingSlot.builder()
                    .isEmpty(true)
                    .parkingLotId(entityLot.getId())
                    .build();
            parkingSlotRepository.save(slot);
        }
    }


}
