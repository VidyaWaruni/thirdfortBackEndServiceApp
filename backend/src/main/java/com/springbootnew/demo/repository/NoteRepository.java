package com.springbootnew.demo.repository;

import com.springbootnew.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Integer> {
    Note findById(int id);

    Boolean existsById(int n_id);

    Boolean existsByuId(String u_id);

    Note deleteById(int n_id);

    List<Note> findAllByuIdAndStatus(String u_id,int status);

    Boolean existsByuIdAndStatus(String u_id,int status);

}