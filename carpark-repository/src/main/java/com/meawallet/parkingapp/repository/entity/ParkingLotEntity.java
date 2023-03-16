package com.meawallet.parkingapp.repository.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@Table(name="parking_lots")
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lot_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "slot_count")
    private Integer slotCount;
    @Column(name = "empty_slots")
    private Integer emptySlots;

    @OneToMany (cascade = CascadeType.ALL)
    @Column(name = "parking_slot_entities")
    @JoinTable(name = "parking_lot_with_slots",
            joinColumns = @JoinColumn(name = "lot_id"),
            inverseJoinColumns = @JoinColumn(name = "slot_id"))
    private List<ParkingSlotEntity> parkingSlotEntities;

/*    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "slot_id")
    private List<ParkingSlotEntity> parkingSlotEntities;*/

    @OneToOne
    @JoinColumn(name = "guard_id", referencedColumnName = "id")
    private GuardEntity guardEntity;
}
