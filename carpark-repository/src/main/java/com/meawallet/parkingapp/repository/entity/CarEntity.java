package com.meawallet.parkingapp.repository.entity;

import com.meawallet.parkingapp.domain.ParkingSlot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name="cars")
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "car_make")
    private String carMake;

/*    @OneToOne(mappedBy = "carEntity")
    @JoinColumn(name = "slot_id")
    private ParkingSlotEntity parkingSlotEntity;*/
}
