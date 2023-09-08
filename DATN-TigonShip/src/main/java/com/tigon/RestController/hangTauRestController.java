package com.tigon.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tigon.dao.HangTauDAO;
import com.tigon.model.HangTau;

@CrossOrigin("*")
@RestController
public class hangTauRestController {
    @Autowired
    HangTauDAO hangTauDAO;

    @GetMapping("/rest/hangtau")
    public List<HangTau> getAllLoaiBanh() {
        List<HangTau> list = hangTauDAO.findAll();
        return list;
    }
    @GetMapping("/rest/hangtau/{id}")
    public HangTau getOne(@PathVariable("id") Integer id) {
        return hangTauDAO.findById(id).get();
    }
    @PostMapping("/rest/hangtau/save")
    public HangTau save(@RequestBody HangTau hangTau) {
        return hangTauDAO.save(hangTau);
    }
    @PutMapping("/rest/hangtau/{id}")
    public HangTau update(@PathVariable("id") Integer id, @RequestBody HangTau hangTau) {
        return hangTauDAO.save(hangTau);
    }
    
    @DeleteMapping("/rest/hangtau/{id}")
    public void delete(@PathVariable("id") Integer id) {
      hangTauDAO.deleteById(id);
    }

}
