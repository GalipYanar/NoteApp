package com.example.noteApp.service;

import com.example.noteApp.model.NoteApp;
import com.example.noteApp.repository.NoteAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteAppService {

    @Autowired
    private NoteAppRepository noteAppRepository;

    public NoteApp createNote(NoteApp noteApp){
       return noteAppRepository.save(noteApp);
    }

    public List <NoteApp> getAllNotesList(){
        return noteAppRepository.findAll();
    }

    public NoteApp findNotesById(Long id){
        Optional<NoteApp> noteApp= noteAppRepository.findById(id);
        if (noteApp.isPresent()){
            return noteApp.get();
        }else {
            throw new RuntimeException(id+" numaralı id notu bulunamadı");
        }
    }

    public void deleteNoteById (Long id){
        noteAppRepository.deleteById(id);
    }

    public NoteApp updateNote(NoteApp noteApp){
        return noteAppRepository.save(noteApp);
    }
}
