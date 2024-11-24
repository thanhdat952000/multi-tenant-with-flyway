//package dev.sultanov.springdata.multitenancy.service;
//
//import dev.sultanov.springdata.multitenancy.entity.Agency;
//import dev.sultanov.springdata.multitenancy.repository.AgencyRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NoteService {
//
//    private AgencyRepository repository;
//
//    public NoteService(AgencyRepository repository) {
//        this.repository = repository;
//    }
//
//    public Agency createNote(Agency note) {
//        return repository.save(note);
//    }
//
//    public Agency findNote(Long id) {
//        return repository.findById(id).orElseThrow();
//    }
//
//    public Iterable<Agency> findAllNotes() {
//        return repository.findAll();
//    }
//}
