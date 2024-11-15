package se331.lab.rest.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.service.EventService;
import se331.lab.rest.entity.Event;
import jakarta.annotation.PostConstruct;
import se331.lab.rest.util.LabMapper;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {
//    List<Event> eventList;
//
//    @PostConstruct
//    public void init() {
//        eventList = new ArrayList<>();
//
//        eventList.add(Event.builder()
//                .id(123L)
//                .category("animal welfare")
//                .title("Cat Adoption Day")
//                .description("Find your new feline friend at this event.").location("Meow Town")
//                .date("January 28, 2022")
//                .time("12:00")
//                .petAllowed(true)
//                .organizer("Kat Laydee")
//                .build());
//        eventList.add(Event.builder()
//                .id(456L)
//                .category("food")
//                .title("Community Gardening")
//                .description("Join us as we tend to the community edible plants.")
//                .location("Flora City")
//                .date("March 14, 2022")
//                .time("10:00")
//                .petAllowed(true)
//                .organizer("Fern Pollin")
//                .build());
//        eventList.add(Event.builder()
//                .id(841L)
//                .category("sustainability")
//                .title("Beach Cleanup")
//                .description("Help pick up trash along the shore.")
//                .location("Playa Del Carmen")
//                .date("July 22, 2022")
//                .time("11:00")
//                .petAllowed(false)
//                .organizer("Carey Wales")
//                .build());
//        eventList.add(Event.builder()
//                .id(114L)
//                .category("Live")
//                .title("Live house")
//                .description("Watch band live")
//                .location("Shimokitazawa")
//                .date("July 24, 2023")
//                .time("11:00")
//                .petAllowed(false)
//                .organizer("Kita Yudai")
//                .build());
//        eventList.add(Event.builder()
//                .id(789L)
//                .category("sustainability")
//                .title("Cat Adoption Day")
//                .description("Help pick up trash along the shore.")
//                .location("Playa Del Carmen")
//                .date("July 22, 2022")
//                .time("11:00")
//                .petAllowed(false)
//                .organizer("Carey Wales")
//                .build());
//        eventList.add(Event.builder()
//                .id(100L)
//                .category("animal welfare")
//                .title("Dog Adoption Day")
//                .description("Find your new canine friend at this event.")
//                .location("Woof Town")
//                .date("August 28, 2022")
//                .time("12:00")
//                .petAllowed(true)
//                .organizer("Dawg Dahd")
//                .build());
//    }
    final EventService eventService;
    @GetMapping("events")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage, @RequestParam(value = "_page", required = false) Integer page) {
//        perPage = perPage == null ? eventList.size() : perPage;
//        page = page == null ? 1 : page;
//        Integer firstIndex = (page - 1) * perPage;
//        List<Event> output = new ArrayList<>();
        Page<Event> pageOutput = eventService.getEvents(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new
                ResponseEntity<>(LabMapper.INSTANCE.getEventDto(pageOutput.getContent())
                ,responseHeader,HttpStatus.OK);

    }
    @GetMapping("events/{id}")
 public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
//         Event output = null;
//         for (Event event :
//                 eventList) {
//             if (event.getId().equals(id)) {
//                 output = event;
//                 break;
//                 }
//             }
        Event output = eventService.getEvent(id);
         if (output != null){
             return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));
             }else {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
                     }
         }
@PostMapping("/events")
public ResponseEntity<?> addEvent(@RequestBody Event event){
         Event output = eventService.save(event);
    return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));
         }
}
