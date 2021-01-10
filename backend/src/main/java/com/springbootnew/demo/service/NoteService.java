package com.springbootnew.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootnew.demo.entity.Note;
import com.springbootnew.demo.repository.NoteRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;
    Note n;
    ObjectMapper mapper = new ObjectMapper();

    //----------------------------Save a new Note----------------------------------------------------------//
    public String saveNote(Note note) throws JSONException {
        try{
            repository.save(note);
            JSONObject outputJsonObj = new JSONObject();
            outputJsonObj.put("message", "Note added Successfully").put("note id",note.getNId());
            return outputJsonObj.toString();
        }catch(Exception e){
            JSONObject outputJsonObj = new JSONObject();
            outputJsonObj.put("Exception",e.getMessage());
            return outputJsonObj.toString();
        }
    }
    //----------------------------Save a new Note----------------------------------------------------------//

    //---------------------------------Update Note--------------------------------------------------------//
    public String updateNote(int n_id,String u_id,String note) throws JSONException {
        try{
            JSONObject outputJsonObj = new JSONObject();
            if(repository.existsById(n_id) && repository.existsByuId(u_id)){
                n = repository.findById(n_id);
                n.setNote(note);
                repository.save(n);
                outputJsonObj.put("message", "Note Updated Successfully").put("note id", n.getNId()).put("note", n.getNote());
            }else{
                outputJsonObj.put("message", "Invalid Note Access");
            }
            return outputJsonObj.toString();
        }catch (Exception e){
            JSONObject outputJsonObj = new JSONObject();
            outputJsonObj.put("Exception",e.getMessage());
            return outputJsonObj.toString();
        }

    }
    //----------------------------Update Note----------------------------------------------------------//

    //----------------------------Delete Note----------------------------------------------------------//
    public String deleteNote(int n_id,String u_id) throws JSONException {
        try{
            JSONObject outputJsonObj = new JSONObject();
            if(repository.existsById(n_id) && repository.existsByuId(u_id)) {
                repository.deleteById(n_id);
                outputJsonObj.put("message", "Note Deleted Successfully").put("note id", n_id);
            }else{
                outputJsonObj.put("message", "Invalid Note Access");
            }
            return outputJsonObj.toString();
        }catch (Exception e){
            JSONObject outputJsonObj = new JSONObject();
            outputJsonObj.put("Exception",e.getMessage());
            return outputJsonObj.toString();
        }
    }
    //----------------------------Delete Note----------------------------------------------------------//

    //----------------------------Archive or Unarchive a Note----------------------------------------------------------//
    public String updateNote(int n_id,String u_id,int status) throws JSONException {
        try{
            JSONObject outputJsonObj = new JSONObject();
            if(repository.existsById(n_id) && repository.existsByuId(u_id)) {
                n = repository.findById(n_id);
                if(n.getStatus()==1 && status==1){
                    outputJsonObj.put("message", "Note Already Archived").put("note id", n.getNId());
                } else if(n.getStatus()==0 && status==0){
                    outputJsonObj.put("message", "Note Already Unarchived").put("note id", n.getNId());
                } else {
                    n.setStatus(status);
                    repository.save(n);
                    if (status == 0) {
                        outputJsonObj.put("message", "Note Unarchived Successfully").put("note id", n.getNId());
                    } else {
                        outputJsonObj.put("message", "Note Archived Successfully").put("note id", n.getNId());
                    }
                }
            } else{
                outputJsonObj.put("message", "Invalid Note Access");
            }
                return outputJsonObj.toString();
        }catch (Exception e){
            JSONObject outputJsonObj = new JSONObject();
            outputJsonObj.put("Exception",e.getMessage());
                return outputJsonObj.toString();
            }
    }
    //----------------------------Archive or Unarchive a Note----------------------------------------------------------//

    //----------------------------List of Notes----------------------------------------------------------//
    public String NoteList(String u_id,int status) throws JSONException {
        try{
            if(repository.existsByuId(u_id)) {
                if (repository.existsByuIdAndStatus(u_id, status)) {
                    String json = mapper.writeValueAsString(repository.findAllByuIdAndStatus(u_id, status));
                    return json;
                } else {
                    JSONObject outputJsonObj = new JSONObject();
                    outputJsonObj.put("message", "Notes are empty");
                    return outputJsonObj.toString();
                }
            }else{
                JSONObject outputJsonObj = new JSONObject();
                outputJsonObj.put("message", "User Not Found");
                return outputJsonObj.toString();
            }
        }catch (Exception e){
            JSONObject outputJsonObj = new JSONObject();
            outputJsonObj.put("Exception",e.getMessage());
            return outputJsonObj.toString();
        }
    }
    //----------------------------List of Notes----------------------------------------------------------//

}
