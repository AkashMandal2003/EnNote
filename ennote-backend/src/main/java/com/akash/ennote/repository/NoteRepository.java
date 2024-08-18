package com.akash.ennote.repository;

import com.akash.ennote.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByOwnerUserName(String ownerUsername);

}
