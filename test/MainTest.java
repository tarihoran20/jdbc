
package test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import daos.RegionDAO;
import models.Region;
import tools.DbConnection;
import tools.Main;

public class MainTest {
    
    @Test
    public void processgetAllRegions(){

      System.out.println("");
      
      Main main = new Main();
      DbConnection connection = new DbConnection();
      RegionDAO rdao = new RegionDAO(connection.getConnection());

      List<Region> expected = new ArrayList<>(); 
      Region a = new Region();
      a.setRegionId(1);
      a.setRegionName("Jakarta");
      Region b = new Region();
      b.setRegionId(2);
      b.setRegionName("Surabaya");
      Region c = new Region();
      c.setRegionId(3);
      c.setRegionName("Medan");
      Region d = new Region();
      d.setRegionId(4);
      d.setRegionName("Depok");
      Region e = new Region();
      e.setRegionId(5);
      e.setRegionName("Samarinda");
      Region f = new Region();
      f.setRegionId(6);
      f.setRegionName("Denpasar");

      expected.add(a);
      expected.add(b);
      expected.add(c);
      expected.add(d);
      expected.add(e);
      expected.add(f);

      List<Region> actual = rdao.getAll();
      
      //assertEquals(expected, actual);
  
      //assertArrayEquals(expected, actual);

      //List<String> list1 = Arrays.asList("1", "Jakarta");
     
      Assert.assertEquals(expected, actual);
   
      
      //Assertions.assertIterableEquals(expected, actual);
    
      

      
      
      
      
      
    }
}
