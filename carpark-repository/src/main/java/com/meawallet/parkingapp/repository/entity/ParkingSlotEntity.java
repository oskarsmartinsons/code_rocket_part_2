package com.meawallet.parkingapp.repository.entity;

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
    Integer id;
    @Column (name = "is_Empty")
    boolean isEmpty;
    @Column (name = "parking_lot_id")
    Integer parkingLotId;
    @Column (name = "car_id")
    Integer carId;
}
