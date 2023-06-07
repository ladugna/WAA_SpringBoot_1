package cs.cs545.midexampractice.midexampractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AddressForBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long address_id;
    private String country;
    private String city;
    private String state;
    private String zipcode;
    @OneToOne(mappedBy = "address")
    private Author author;

}
