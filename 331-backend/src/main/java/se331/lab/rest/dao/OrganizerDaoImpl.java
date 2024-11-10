package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .name("Kat Laydee")
                .address("Meow Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(456L)
                .name("Fern Pollin")
                .address("Flora City")
                .build());
        organizerList.add(Organizer.builder()
                .id(841L)
                .name("Carey Wales")
                .address("Playa Del Carmen")
                .build());
        organizerList.add(Organizer.builder()
                .id(114L)
                .name("Kita Ikuyo")
                .address("Shimokitazawa")
                .build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .name("Carey Wales")
                .address("Playa Del Carmen")
                .build());
        organizerList.add(Organizer.builder()
                .id(100L)
                .name("Dawg Dahd")
                .address("Woof Town")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        int lastIndex = Math.min(firstIndex + pageSize, organizerList.size());

        // 对组织者列表按 id 进行排序
        List<Organizer> sortedOrganizers = organizerList.stream()
                .sorted((o1, o2) -> Long.compare(o1.getId(), o2.getId()))
                .collect(Collectors.toList());

        return sortedOrganizers.subList(firstIndex, lastIndex);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream()
                .filter(organizer -> id.equals(organizer.getId()))
                .findFirst()
                .orElse(null);
    }
}
