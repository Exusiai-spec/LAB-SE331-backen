package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class EventDaoImpl implements EventDao {
    List<Event> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .build());
        eventList.add(Event.builder()
                .id(841L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .build());
        eventList.add(Event.builder()
                .id(114L)
                .category("Live")
                .title("Live house")
                .description("Watch band live")
                .location("Shimokitazawa")
                .date("July 24, 2023")
                .time("11:00")
                .petAllowed(false)
                .build());
        eventList.add(Event.builder()
                .id(789L)
                .category("sustainability")
                .title("Cat Adoption Day")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .build());
        eventList.add(Event.builder()
                .id(100L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .build());
    }
@Override
public Integer getEventSize() {
        return eventList.size();
    }

@Override
public Page<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
//        Integer firstIndex = (page - 1) * pageSize;
//        List<Event> output = new ArrayList<>();
//        for (int i = firstIndex; i < firstIndex + pageSize; i++) {
//             output.add(eventList.get(i));
//             }
//         return output;
       int firstIndex = (page - 1) * pageSize;
    return new
            PageImpl<Event>(eventList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,
            pageSize),eventList.size());
         }

@Override
public Event getEvent(Long id) {
//         Event output = null;
//         for (Event event :
//                eventList) {
//             if (event.getId().equals(id)) {
//                 output = event;
//                 break;
//                 }
//             }
//         return output;
            return eventList.stream().filter(event ->
            event.getId().equals(id)).findFirst().orElse(null);
         }
@Override
public Event save(Event event) {
         event.setId(eventList.get(eventList.size()-1).getId()+1);
         eventList.add(event);
         return event;
         }
}
