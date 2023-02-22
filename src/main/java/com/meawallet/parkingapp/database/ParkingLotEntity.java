package com.meawallet.parkingapp.database;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name="parking_lots")
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "slot_count")
    private Integer slotCount;
    @Column(name = "empty_slots")
    private Integer emptySlots;
}
