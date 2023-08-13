package me.mourjo.jamboree.service;

import me.mourjo.jamboree.data.Party;
import me.mourjo.jamboree.data.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartyService {
    private final PartyRepository repository;
    private final IDGenerator idGenerator;

    PartyService(PartyRepository repository, IDGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Party add(String name, String location) {
        Party p = new Party(idGenerator.generate(), name, location);
        return repository.save(p);
    }

    public Optional<Party> find(long id) {
        return repository.findById(id);
    }
}