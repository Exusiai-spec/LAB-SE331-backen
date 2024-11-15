package se331.lab.rest.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.*;

import se331.lab.rest.entity.EventOrganizerDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
 Long id;
 String category;
 String title;
 String description;
 String location;
 String date;
 String time;
 Boolean petAllowed;
 EventOrganizerDTO organizer;
}
