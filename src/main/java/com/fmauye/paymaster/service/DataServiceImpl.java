/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.service.DataService;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */

@Service
public class DataServiceImpl implements DataService {

    @Override
    public Map<Integer, Double> getLineChartData() {
       Map<Integer, Double> map = new LinkedHashMap<>();
      map.put(1, 5.20);
      map.put(2, 19.63);
      map.put(3, 59.01);
      map.put(4, 139.76);
      map.put(5, 300.4);
      map.put(6, 630.0);
        return  map;
    }
    
}
