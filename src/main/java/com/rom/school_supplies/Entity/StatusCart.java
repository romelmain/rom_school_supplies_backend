package com.rom.school_supplies.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "status_carrito")
public class StatusCart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statuscart_sequence")
    @SequenceGenerator(name = "statuscart_sequence", sequenceName = "statuscart_sequence", allocationSize = 1)
    private Integer id;

    private String status;

}