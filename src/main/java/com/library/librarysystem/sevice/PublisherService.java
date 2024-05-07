package com.library.librarysystem.sevice;

import com.library.librarysystem.entity.Publisher;
import com.library.librarysystem.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    public List<Publisher> findAllPublishers() {
        return  publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {
        Publisher publisher;
        publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher no found"));
        return publisher;
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void removePublisherById(Long id) {
        Publisher publisher;
        publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
        publisherRepository.deleteById(publisher.getId());
    }
}
