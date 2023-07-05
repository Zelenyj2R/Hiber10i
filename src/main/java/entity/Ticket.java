package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    private long id;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "client_id")
    private int client;
    @Column(name = "from_planet_id")
    private String from_planet_id;
    @Column(name = "to_planet_id")
    private String to_planet_id;

}
