package com.meawallet.parkingapp.database;

import jakarta.persistence.*;
import lombok.*;

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
