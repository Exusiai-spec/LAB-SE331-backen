package se331.lab.rest.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.lab.rest.entity.Event;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {
    List<Event> eventList;
    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.") .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
        eventList.add(Event.builder()
                 .id(456L)
                 .category("food") .title("Community Gardening")
                 .description("Join us as we tend to the community edible plants.")
                 .location("Flora City")
                 .date("March 14, 2022")
                 .time("10:00")
                 .petAllowed(true)
                 .organizer("Fern Pollin")
                 .build());
        eventList.add(Event.builder()
                        .id(841L)
                        .category("sustainability")
                        .description("Help pick up trash along the shore.")
                        .location("Playa Del Carmen")
                        .date("July 22, 2022")
                        .time("11:00")
                        .petAllowed(false)
                        .organizer("Carey Wales")
                        .build());
        eventList.add(Event.builder()
                .id(114L)
                .category("Live")
                .description("Watch band live")
                .location("Shimokitazawa")
                .date("July 24, 2023")
                .time("11:00")
                .petAllowed(false)
                .organizer("Kita Yudai")
                .build());
        eventList.add(Event.builder()
                .id(789L)
                .category("sustainability")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Carey Wales")
                .build());
        eventList.add(Event.builder()
                .id(100L)
                .category("animal welfare")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Dawg Dahd")
                .build());
 }
    @GetMapping("events")
    public ResponseEntity<?> getEventLists(){
        return ResponseEntity.ok(eventList);
}

}