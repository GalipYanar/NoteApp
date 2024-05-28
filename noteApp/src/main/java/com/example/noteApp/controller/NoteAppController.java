package com.example.noteApp.controller;

import com.example.noteApp.NoteAppApplication;
import com.example.noteApp.model.NoteApp;
import com.example.noteApp.service.NoteAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin // bunu kullanmamızın sebebi kendi local'imizden kendi local'imize istek atarken hata almamız
// sistem bunu bir risk olarak algılıyor ve bu anatasyonu kullanmamız gerekiyor
public class NoteAppController {

    @Autowired
    private NoteAppService noteAppService;

    @PostMapping("/create")
    public NoteApp createNote(@RequestBody NoteApp noteApp){
        return noteAppService.createNote(noteApp);
    }

    @GetMapping
    public List <NoteApp> getAllNotesList(){
        return noteAppService.getAllNotesList();
    }

    @GetMapping("/{id}")
    public NoteApp findNotesById(@PathVariable("id") Long id){
        return noteAppService.findNotesById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable("id") Long id){
        noteAppService.deleteNoteById(id);
    }

    @PutMapping("/update/{id}")
    public NoteApp updateNote(@PathVariable("id")Long id, @RequestBody NoteApp noteApp){
        return noteAppService.updateNote(noteApp);
    }

}
