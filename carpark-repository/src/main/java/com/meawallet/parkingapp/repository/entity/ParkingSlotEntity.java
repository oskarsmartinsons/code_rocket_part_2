package com.meawallet.parkingapp.repository.entity;

import com.meawallet.parkingapp.domain.ParkingLot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name="parking_slots")
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlotEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Integer id;
    @Column (name = "slot_number")
    private Integer slotNumber;
    @Column (name = "is_empty")
    private boolean isEmpty;

}
