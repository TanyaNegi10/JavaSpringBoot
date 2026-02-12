package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    private List<Demo> demos=new ArrayList<>();
    private Long nextId=1L;
    public DemoService()
    {
    }
    public List<Demo> getAllDemo()
    {
        return demos;
    }
    public boolean addDemo(Demo demo)
    {
        if(demo!=null)
        {
            demo.setId(nextId++);
            demos.add(demo);
            return true;
        }else{
            return  false;
        }
    }
    public Demo getDemoByMonth(String month)
    {
        for(Demo demo:demos)
        {
            if(demo.getMonth().equals(month))
            {
                return demo;
            }
        }
        return null;
    }


    public Demo updateDemo(Long id, Demo updateddemo)
    {
        for (Demo dem : demos)
        {
            if (dem.getId().equals(id))
            {
                System.out.println("Before update: " + dem);
                dem.setMonth(updateddemo.getMonth());
                dem.setDescription(updateddemo.getDescription());
                System.out.println("After update: " + dem);
                return dem;
            }
        }
        System.out.println("No demo found for id: " + id);
        return null;
    }

    public boolean deleteDemo(Long id)
    {
        return demos.removeIf(demo -> demo.getId().equals(id));
    }


}
