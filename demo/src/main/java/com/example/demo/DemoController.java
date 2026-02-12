package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    private DemoService demoService;

    public DemoController(DemoService demoService)
    {
        this.demoService=demoService;
    }
    @GetMapping("/demo")
    public ResponseEntity<List<Demo>> getAllDemo()
    {
        return new ResponseEntity<>(demoService.getAllDemo(), HttpStatus.OK);
    }

    @PostMapping("/demo")
    public ResponseEntity<Demo> addDemo(@RequestBody Demo demo)
    {

        boolean isdemoAdded=demoService.addDemo(demo);
        if(isdemoAdded)
        {
            return new ResponseEntity<>(demo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demo/{month}")
    public ResponseEntity<Demo> getDemoByMonth(@PathVariable String month)
    {
        Demo demo= demoService.getDemoByMonth(month);
        if(demo!=null)
        {
            return new ResponseEntity<>(demo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/demo/{id}")
    public ResponseEntity<Demo> updateDemo(@PathVariable Long id, @RequestBody Demo demo)
    {
        Demo updatedDemo = demoService.updateDemo(id, demo);
        if (updatedDemo != null)
        {
            return new ResponseEntity<>(updatedDemo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("demo/{id}")
    public ResponseEntity<String> deleteDemo(@PathVariable Long id)
    {
        boolean isDemoDeleted=demoService.deleteDemo(id);
        if(isDemoDeleted)
        {
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
