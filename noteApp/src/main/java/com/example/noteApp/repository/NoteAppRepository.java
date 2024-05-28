package com.example.noteApp.repository;

import com.example.noteApp.model.NoteApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteAppRepository extends JpaRepository<NoteApp,Long> {
}
