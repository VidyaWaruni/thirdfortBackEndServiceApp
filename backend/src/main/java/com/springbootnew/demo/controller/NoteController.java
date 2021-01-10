package com.springbootnew.demo.controller;

import com.springbootnew.demo.entity.Note;
import com.springbootnew.demo.service.NoteService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    @Autowired
    private NoteService service;

    @PostMapping("/notes/addNote")
    @ResponseBody
    public String addNote(@RequestBody Note note) throws JSONException {
        return service.saveNote(note);
    }

    @PutMapping("/notes/updateNote")
    @ResponseBody
    public String updateNote(@RequestHeader int n_id,@RequestHeader String u_id,@RequestBody String note) throws JSONException {
        return service.updateNote(n_id, u_id, note);
    }

    @DeleteMapping("/notes/deleteNote")
    public String deleteNote(@RequestHeader int n_id,@RequestBody String u_id) throws JSONException {
        return service.deleteNote(n_id, u_id);

    }

    @PutMapping("/notes/archiveNote")
    public String archiveNote(@RequestHeader int n_id,@RequestBody String u_id) throws JSONException {
        return service.updateNote(n_id, u_id, 1);

    }

    @PutMapping("/notes/unarchiveNote")
    @ResponseBody
    public String unarchiveNote(@RequestHeader int n_id,@RequestBody String u_id) throws JSONException {
        return service.updateNote(n_id, u_id, 0);
    }

    @GetMapping("/notes/archiveNotes")
    public String  findArchiveNotes(@RequestHeader String u_id) throws JSONException {
        return service.NoteList(u_id, 1);
    }

    @GetMapping("/notes/unarchiveNotes")
    public String findUnarchiveNotes(@RequestHeader String u_id) throws JSONException {
        return service.NoteList(u_id, 0);
    }

}
